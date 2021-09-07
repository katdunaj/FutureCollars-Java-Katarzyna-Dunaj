package pl.futurecollars.invoicing.model;

import java.awt.List;
import java.time.LocalDateTime;
import java.util.UUID;

public class Invoice {
    private UUID id;
    private LocalDateTime date;
    private Company from;
    private Company to;
    private List invoiceEntries;

    public Invoice(UUID id, LocalDateTime date, Company from, Company to, List invoiceEntries) {
        this.id = id;
        this.LocalDateTime = date;
        this.Company = from;
        this.Company = to;
        this.invoiceEntries = invoiceEntries;
    }


}
