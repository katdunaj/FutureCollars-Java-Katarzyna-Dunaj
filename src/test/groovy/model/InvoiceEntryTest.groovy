package model

import pl.futurecollars.invoicing.model.InvoiceEntry
import pl.futurecollars.invoicing.model.Vat
import spock.lang.Specification

class InvoiceEntryTest extends Specification {

    def "should build InvoiceEntry object"() {
        setup:
        def invoiceEntry = new InvoiceEntry("Masa cukrowa", 20 as BigDecimal, "20*5", Vat.VAT_5)

        when:
       def result = invoiceEntry

        then:
        result !=null

    }

    def"should calculate vat value"(){
        setup:
        def invoiceEntry = new InvoiceEntry("Masa cukrowa", 20 as BigDecimal , "20 *5", Vat.VAT_5)

        when:
        def result = invoiceEntry.vatValue

        then:
        result == 1
    }
}
