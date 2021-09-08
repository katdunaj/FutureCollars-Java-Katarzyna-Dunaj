package pl.futurecollars.invoicing.model;

import java.math.BigDecimal;

public class InvoiceEntry<VAT> {
    private String description;
    private BigDecimal price;
    private BigDecimal  vatvalue;
    private VAT vatrate;


public InvoiceEntry(String description, BigDecimal price, BigDecimal vatvalue, VAT vatrate){
    this.description = description;
    this.price = price;
    this.vatvalue = vatvalue;
    this.vatrate = vatrate;
}
}
