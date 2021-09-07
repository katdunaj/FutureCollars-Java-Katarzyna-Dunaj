package pl.futurecollars.invoicing.service;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

class InvoiceService{

    private final Database database;

    public InvoiceService(Database database) {
        this.database = database;

    }
    public Invoice save (Invoice invoice){
        return database.save(invoice);

    }
    public Invoice getById(int id){
        return database.getById(id);
    }
    public List<Invoice> getAll(){
        return (List<Invoice>) database.getAll();
    }
    public Optional<Invoice> update(int id, Invoice updatedInvoice){
        return database.update(id, updatedInvoice);
    }
    public Optional<Invoice> delete( int id) {
        return database.delete(id);
    }
    }




