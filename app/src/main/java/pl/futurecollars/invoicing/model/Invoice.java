package pl.futurecollars.invoicing.model;

import java.awt.List;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Invoice {
    private final LocalDateTime LocalDateTime;
    private final Company Company;
    private UUID id;
    private List invoiceEntries;

    public Invoice(UUID id, LocalDateTime date, Company from, Company to, List invoiceEntries) {
        this.id = id;
        this.LocalDateTime = date;
        this.Company = from;
        this.invoiceEntries = invoiceEntries;
    }
}
