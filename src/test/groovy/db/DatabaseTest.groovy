package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import pl.futurecollars.invoicing.model.InvoiceEntry
import spock.lang.Specification
import java.time.LocalDate


class DatabaseTest extends Specification {

    def inMemoryDatabase = new InMemoryDatabase()
    def from = new Company(UUID.randomUUID(), "Telnet", 12345, "Ul.Ogrodowa 3, 05-085 Kampinos")
    def to = new Company(UUID.randomUUID(), "NetPlus", 23456, "Ul.Kwiatowa 5, 05-085 Kampinos")
    def issuerDate = LocalDate.of(2021, 7, 8)
    def invoiceEntries = new ArrayList<InvoiceEntry>()
    def invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
    def database

    def "should save invoice to the list"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        when:
        Invoice savedInvoice = database.save(invoice)

        then:
        savedInvoice.getId() != null

    }

    def "should get invoice from database by Id"() {

        setup:
        database.save(invoice)

        when:
        def result = database.getById(invoice.getId())

        then:
        result != null
        result.getFrom().getName() == "Telnet"

    }

    def "should get list of all invoices from database"() {
        setup:
        def invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        def invoice2 = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        inMemoryDatabase.save(invoice)
        inMemoryDatabase.save(invoice2)

        when:
        def resultInMemory = inMemoryDatabase.getAll()

        then:
        resultInMemory.size() == 2

    }

    def "should delete invoice from database"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)
        when:

        database.save(invoice)

        then:
        database.getAll().size() == 1

        when:
        database.delete(invoice.getId())

        then:
        database.getAll().size() == 0
    }

    def "should update invoice in database "() {
        setup:
        Invoice updatedInvoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)

        updatedInvoice.setId(invoice.getId())

        when:
        inMemoryDatabase.update(updatedInvoice)

        then:
        inMemoryDatabase.database.get(invoice.getId()) == updatedInvoice
    }

}
