package Fixtures

import fixtures.CompanyFixture
import pl.futurecollars.invoicing.model.Invoice

import java.time.LocalDateTime

class InvoiceFixture {

    static invoice(int id) {
        new Invoice(LocalDateTime.now()
                , CompanyFixture.company(id)
                , CompanyFixture.company(id + 1)
                , List.of(InvoiceEntryFixture.product(id)
                , InvoiceEntryFixture.product(id + 1)
                , InvoiceEntryFixture.product(id + 2)))
    }
}
