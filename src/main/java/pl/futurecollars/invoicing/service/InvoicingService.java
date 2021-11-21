package pl.futurecollars.invoicing.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.db.InMemoryDatabase;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;

@Service
@RequiredArgsConstructor
public class InvoicingService {

    private final InMemoryDatabase database;

    public BigDecimal getTotalNet(Invoice invoice) {
        return invoice.getInvoiceEntries()
            .stream()
            .map(InvoiceEntry::getPrice)
            .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    public BigDecimal getTotalTaxValue(Invoice invoice) {
        return invoice.getInvoiceEntries()
            .stream()
            .map(InvoiceEntry::getVatValue)
            .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    public BigDecimal getTotalGross(Invoice invoice) {
        return getTotalNet(invoice).add(getTotalTaxValue(invoice));
    }

    public List<Invoice> filterByFromName(String fromName) {
        return database.getAll()
            .stream()
            .filter((Invoice invoice) -> fromName.equals(invoice.getFrom().getName()))
            .collect(Collectors.toList());
    }

    public List<Invoice> filterByToName(String toName) {
        return database.getAll()
            .stream()
            .filter((Invoice invoice) -> toName.equals(invoice.getTo().getName()))
            .collect(Collectors.toList());
    }

    public List<Invoice> filterByIssuerDate(LocalDate issuerDate) {
        return database.getAll()
            .stream()
            .filter((Invoice invoice) -> issuerDate.equals(invoice.getIssuerDate()))
            .collect(Collectors.toList());
    }

    public Invoice save(Invoice invoice) {
        return database.save(invoice);
    }

    public Invoice getById(UUID id) {
        return database.getById(id);
    }

    public List<Invoice> getAll() {
        return database.getAll();
    }

    public Invoice update(Invoice updatedInvoice) {
        return database.update(updatedInvoice);
    }

    public boolean delete(UUID id) {
        return database.delete(id);
    }

}
