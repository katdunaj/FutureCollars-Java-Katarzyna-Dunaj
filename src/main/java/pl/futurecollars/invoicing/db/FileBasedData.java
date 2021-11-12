package pl.futurecollars.invoicing.db;

import java.util.List;
import java.util.UUID;
import pl.futurecollars.invoicing.file.FileService;
import pl.futurecollars.invoicing.file.JsonService;
import pl.futurecollars.invoicing.model.Invoice;

public class FileBasedData<T> implements Database {

    FileService fileservice = new FileService();
    JsonService jsonservice = new JsonService();

    @Override
    public Invoice save(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getById(UUID id) {
        return null;
    }

    @Override
    public List<Invoice> getAll() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public Invoice update(Invoice updatedInvoice) {
        return null;
    }
}
