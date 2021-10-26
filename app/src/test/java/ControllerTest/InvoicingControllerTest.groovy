package ControllerTest

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.futurecollars.invoicing.fixtures.InvoiceFixture;
import pl.futurecollars.invoicing.model.Invoice;
import spock.lang.Shared;
import spock.lang.Specification;
import spock.lang.Stepwise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Stepwise
@SpringBootTest
@AutoConfigureMockMvc
class InvoiceControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private pl.futurecollars.invoicing.file.JsonService<Invoice> jsonService //dlaczego po zaimportowaniu zrobiło się coś takiego

    @Shared
    def invoice = InvoiceFixture.invoice(1)


    def "add single invoice"()

    {
        given:
        def invoiceAsJson = jsonService.convertToJson(invoice)

        when:
        def response = mockMvc.perform(
                post("/invoices").content(invoiceAsJson).contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .andExpect(status().isOk())
                .contentAsString
                .response

        invoice.setId(jsonService.convertToObject(response, Invoice.class).getId())

        then:
        invoice == jsonService.convertToObject(response, Invoice.class)
    }

    def "should return list of invoices"()

    {
        when:
        def response = mockMvc.perform(get("/invoices"))
                .andReturn()
                .andExpect(status().isOk())
                .contentAsString
                .response

        def invoices = ArrayList.of(invoice)

        then:
        then:
        invoices.size() > 0
        invoices[0] == invoice
    }
}