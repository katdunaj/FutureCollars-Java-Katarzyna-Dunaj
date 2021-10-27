package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.FileBasedData
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
        def invoice = new Invoice(id,date, from, to, Entries)
        def invoice2 = new Invoice(id,date, from, to, Entries)
        InMemoryDatabase.save(invoice)
        InMemoryDatabase.save(invoice2)
        FileBasedData.save(invoice)
        FileBasedData.save(invoice2)


        when:
        def resultInMemory = InMemoryDatabase.getAll()
        def resultInFile = FileBasedData.getAll()

        then:
        resultInMemory.size() == 2
        resultInFile.size() == 2

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
        database.save(invoice)

        when:
        resultInMemory = InMemoryDatabase.delete(invoice.getId())// zmienić dane i zapisać


        then:
        resultInMemory
        InMemoryDatabase.getAll().size() == 0// sprawdzic czy dane się zmieniły


    }
}