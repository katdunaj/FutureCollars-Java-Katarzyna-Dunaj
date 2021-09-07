package pl.futurecollars.invoicing.db;

import java.awt.List;
import java.util.UUID;
import pl.futurecollars.invoicing.model.Invoice;

public interface Database {

    Invoice save(Invoice invoice);

    Invoice getById(int id);

    List<Invoice> getAll();

    Invoice upDate(Invoice updateInvoice);

    boolean delete(UUID id);


}
