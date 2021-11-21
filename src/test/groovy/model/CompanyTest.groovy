package model

import pl.futurecollars.invoicing.model.Company
import spock.lang.Specification

class CompanyTest extends Specification {

    def "should build company object"() {
        setup:
        def company = new Company(UUID.randomUUID(), "Telnet", 123456, "ul. Ogrodowa 3 Kampinos 05-085")

        when:
        def result = company

        then:
        result != null
    }

}
