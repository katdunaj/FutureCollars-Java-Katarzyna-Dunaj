package pl.futurecollars.invoicing.db;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.file.FileService;
import pl.futurecollars.invoicing.file.JsonService;
import pl.futurecollars.invoicing.model.Invoice;

@Service
@RequiredArgsConstructor
public class FileBasedData<T> implements Database {

    private final FileService fileservice;
    private final JsonService jsonservice;

    @Override
    public Invoice save(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getById(UUID id) {
        return null; }

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