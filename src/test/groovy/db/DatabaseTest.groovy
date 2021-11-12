package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase
import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import pl.futurecollars.invoicing.model.InvoiceEntry
import spock.lang.Specification
import java.time.LocalDate


class DatabaseTest extends Specification {

    def InMemoryDatabase = new InMemoryDatabase()
    def from = new Company(UUID.randomUUID(),"Telnet", 12345,"Ul.Ogrodowa 3, 05-085 Kampinos")
    def to = new Company(UUID.randomUUID(),"NetPlus", 23456,"Ul.Kwiatowa 5, 05-085 Kampinos")
    def issuerDate =  LocalDate.of(2021, 7, 8)
    def invoiceEntries = new ArrayList<InvoiceEntry>();
    def invoice = new Invoice(UUID.randomUUID(), issuerDate, from, to, invoiceEntries)


    def "Save"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
        when:
        Invoice savedInvoice = database.save(invoice)

        then:
        savedInvoice.getId() != null

    }

    def "GetById"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
        Invoice savedInvoice = database.save(invoice)

        when:
        Invoice getInvoice = database.getById(savedInvoice.getId())

        then:
        savedInvoice.getId() == savedInvoice.getId()

    }

    def "GetAll"() {
        setup:
        def invoice = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
        def invoice2 = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
        InMemoryDatabase.save(invoice)
        InMemoryDatabase.save(invoice2)

        when:
        def resultInMemory = InMemoryDatabase.getAll()

        then:
        resultInMemory.size() == 2

    }

    def "delete"() {

        setup:
        Database database = new InMemoryDatabase()
        Invoice invoice = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
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
        def fromUpdated = new Company(UUID.randomUUID(),"Telnet", 12345,"Ul.Ogrodowa 3, 05-085 Kampinos")
        def invoiceUpdated = new Invoice(UUID.randomUUID(),issuerDate, from, to, invoiceEntries)
        Database database = new InMemoryDatabase()
        database.save(invoice)
        invoiceUpdated.setId(invoice.getId())

        when:
        def resultInMemory = InMemoryDatabase.update(invoiceUpdated)

        then:
        InMemoryDatabase.getById(resultInMemory.getId()) != null
        InMemoryDatabase.getById(resultInMemory.getId()).getFrom().getName() == "Telnet"


    }
}