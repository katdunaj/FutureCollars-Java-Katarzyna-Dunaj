package fixtures

import pl.futurecollars.invoicing.model.Company

class CompanyFixture {

    static company(int id) {

        new Company("582467c0-1fbd-4fb4-8a5b-463bd39e7678", "222-333-444", "Ul.Ogrodowa 3, 05-085 Kampinos", "AAA")

    }
}