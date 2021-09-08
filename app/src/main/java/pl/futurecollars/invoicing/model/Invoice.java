package pl.futurecollars.invoicing.model;

import java.awt.List;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Invoice {
    private final LocalDateTime LocalDateTime;
    private final Company Company;
    private UUID id;
    private List invoiceEntries;

    public Invoice(UUID id, LocalDateTime date, Company from, Company to, List invoiceEntries) {
        pl.futurecollars.invoicing.model.Company Company1;
        this.id = id;
        this.LocalDateTime = date;
        Company1 = from;
        Company1 = to;
        this.Company = Company1;
        this.invoiceEntries = invoiceEntries;
    }


}
