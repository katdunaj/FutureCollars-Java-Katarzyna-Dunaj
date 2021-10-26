package DatabaseTest

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import pl.futurecollars.invoicing.model.InvoiceEntry
import spock.lang.Specification

import java.time.LocalDateTime

abstract class DatabaseTest extends Specification {

    abstract Database getDatabaseInstance();

    def issuer = new Company("7ce03334-363f-11ec-8d3d-0242ac130003", "111-22-44-333", "Ul. Ogrodowa 3/6, 05-085 Kampinos", "GGG")
    def receiver = new Company("83ef0c68-363f-11ec-8d3d-0242ac130003", "123-12-24-657", "Ul.Miła 1/23, 00-180 Warszawa", "BBB")
    def date = new LocalDateTime(2020, 12, 18, 14, 30)
    def entries = new ArrayList<InvoiceEntry>();
    def invoice = new Invoice (date, issuer, receiver, entries)
    Database database

    def setup(){
        database = getDatabaseInstance()
    }
    def "should save invoice"() {
        when:
        def result = database.save(invoice)

        then:
        database.getById(result.getId()) != null
        database.getById(result.getId()).getIssuer().getName() == "GGG"
    }
    def "should get invoice from by id"() {
        setup:
        database.save(invoice)

        when:
        def result = database.getById(invoice.getId())

        then:
        result != null
        result.getIssuer().getName() == "GGG"
    }

    def "should get list of all invoice "(){
        setup:
        def invoice2 = new Invoice(date, issuer, receiver, entries)
        def invoice3 = new Invoice(date, issuer, receiver, entries)
        database.save(invoice)
        database.save(invoice2)
        database.save(invoice3)

        when:
        def result = database.getAll()

        then:
        result.size() == 3
    }

    def "should delete invoice"() {
        setup:
        database.save(invoice)

        when:
        def result = database.delete(invoice.getId())

        then:
        result
        database.getAll().size() == 0
    }

    def "should update invoice in the database"() {
        setup:
        database.save(invoice)
        def issuerUpdated = new Company("7ce03334-363f-11ec-8d3d-0242ac130003", "111-22-44-333", "Ul. Ogrodowa 3/6, 05-085 Kampinos", "ZZZ")
        def invoiceUpdated = new Invoice(date, issuerUpdated, receiver, entries)
        invoiceUpdated.setId(invoice.getId())

        when:
        def result = database.update(invoiceUpdated)

        then:
        database.getById(result.getId()) != null
        database.getById(result.getId())..getIssuer().getName() == "ZZZ"
    }

    def "should delete not existing UUID"(){
        when:
        def result = database.delete(UUID.randomUUID())

        then:
        result!
        database.getAll().size() == 0

    }
}

