package fixtures

import pl.futurecollars.invoicing.model.Company

class CompanyFixture {

    static company(int id) {

        new Company("7ce03334-363f-11ec-8d3d-0242ac130003", "111-22-44-333", "Ul. Ogrodowa 3/6, 05-085 Kampinos", "GGG")

    }
}