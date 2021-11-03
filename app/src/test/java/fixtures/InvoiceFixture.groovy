package fixtures

import pl.futurecollars.invoicing.model.Invoice

import java.time.LocalDate


class InvoiceFixture {

    static invoice(int id) {
        new Invoice(LocalDate.now()
                , CompanyFixture.company(id)
                , CompanyFixture.company(id + 1)
                , List.of(InvoiceEntryFixture.product(id)
                , InvoiceEntryFixture.product(id + 1)
                , InvoiceEntryFixture.product(id + 2)))
    }
}
