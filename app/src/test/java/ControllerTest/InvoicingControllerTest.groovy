package ControllerTest

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc
import pl.futurecollars.invoicing.file.JsonService;
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
    private JsonService jsonService

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

    }
}