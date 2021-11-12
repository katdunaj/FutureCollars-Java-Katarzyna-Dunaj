package DatabaseTest

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import pl.futurecollars.invoicing.model.InvoiceEntry
import spock.lang.Specification

import java.time.LocalDate

abstract class DatabaseTest extends Specification {

    abstract Database getDatabaseInstance();

    def InMemoryDatabase = new InMemoryDatabase()
    def from = new Company(UUID.randomUUID(),"Telnet", 12345,"Ul.Ogrodowa 3, 05-085 Kampinos")
    def to = new Company(UUID.randomUUID(),"NetPlus", 23456,"Ul.Kwiatowa 5, 05-085 Kampinos")
    def issuerDate =  LocalDate.of(2021, 7, 8)
    def invoiceEntries = new ArrayList<InvoiceEntry>();
    def invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
    Database database;

    def setup(){
        database = getDatabaseInstance()
    }
    def "should save invoice"() {
        when:
        def result = database.save(invoice)

        then:
        database.getById(result.getId()) != null
        database.getById(result.getId()).getFrom().getName() == "Telnet"
    }
    def "should get invoice from by id"() {
        setup:
        database.save(invoice)

        when:
        def result = database.getById(invoice.getId())

        then:
        result != null
        result.getFrom().getName() == "Telnet"
    }

    def "should get list of all invoice "(){
        setup:
        def invoice2 = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        def invoice3 = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
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
        def issuerUpdated = new Company(UUID.randomUUID(),"Telnet", 12345,"Ul.Ogrodowa 3, 05-085 Kampinos")
        def invoiceUpdated = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        invoiceUpdated.setId(invoice.getId())

        when:
        def result = database.update(invoiceUpdated)

        then:
        database.getById(result.getId()) != null
        database.getById(result.getId()).getFrom().getName() == "Telnet"
    }

    def "should delete not existing UUID"(){
        when:
        def result = database.delete(UUID.randomUUID())

        then:
        result

        database.getAll().size() == 0
    }
}

