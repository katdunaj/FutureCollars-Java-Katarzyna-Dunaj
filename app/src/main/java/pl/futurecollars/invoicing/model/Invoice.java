package pl.futurecollars.invoicing.model;

import java.awt.List;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Invoice {
    private final LocalDate LocalDate;
    private final Company Company;
    private UUID id;
    private List invoiceEntries;

    public Invoice(UUID id, LocalDate date, Company from, Company to, List invoiceEntries) {
        this.id = id;
        this.LocalDate = date;
        this.Company = from;
        this.invoiceEntries = invoiceEntries;
    }
}