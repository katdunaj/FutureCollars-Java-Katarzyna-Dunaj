package pl.futurecollars.invoicing.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import pl.futurecollars.invoicing.model.Invoice;

public class InMemoryDatabase implements Database {

    HashMap<UUID, Invoice> database = new HashMap<UUID, Invoice>();

    @Override
    public Invoice save(Invoice invoice) {
        UUID id = UUID.randomUUID();
        invoice.setId(id);

        if (database.get(id) != null) {
            return save(invoice);
        }
        database.put(id, invoice);
        return invoice;
    }

    @Override
    public Invoice getById(int id) {
        return database.get(id);
    }

    @Override
    public List<Invoice> getAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Invoice upDate(Invoice updateInvoice) {
        return null;
    }

    @Override
    public Invoice update(Invoice updatedInvoice) {
        database.put(updatedInvoice.getId(), updatedInvoice);
        return updatedInvoice;
    }

    @Override
    public boolean delete(UUID id) {
        try {
            database.remove(id);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}

