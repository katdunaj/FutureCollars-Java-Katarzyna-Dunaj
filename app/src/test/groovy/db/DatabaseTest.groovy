package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification

import java.awt.List
import java.time.LocalDateTime

class DatabaseTest extends Specification {
    def "Save"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(), LocalDateTime.now(), new Company(), new Company(), new ArrayList<>())
        when:
        Invoice savedInvoice = database.save(invoice)

        then:
        savedInvoice.getId() != null

    }

    def "GetById"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice()
        Invoice savedInvoice = database.save(invoice)

        when:
        Invoice getInvoice = database.getById(savedInvoice.getId())

        then:
        savedInvoice.getId() == savedInvoice.getId()

    }

    def "GetAll"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice()

        for (int i = 0; i > 10; i++) {
            database.save(invoice)
        }

        when:


        then:

    }

    def "delete"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice()
        when:
        database.save(invoice)
        then:
        database.getAll().size() == 1
        when:
        database.delete(invoice.getId())

        then:
        database.getAll().size() == 0
    }

    def "updated"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(Company)
        when:
        database.save(Company)
        then:
        database.getAll().size() == 1
        when:
        database.update(Company.update(Company))
        then:
        database.getAll().size() == 0 sprawdzic czy jedno rowna sie drugie
    }
}