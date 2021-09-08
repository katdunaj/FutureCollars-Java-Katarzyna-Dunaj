package pl.futurecollars.invoicing.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import pl.futurecollars.invoicing.model.Invoice;

public interface Database {

    Invoice save(Invoice invoice);

    Invoice getById(int id);

    List<Invoice> getAll();

    boolean delete(UUID id);

    Optional<Invoice> update(Invoice updatedInvoice);
}
