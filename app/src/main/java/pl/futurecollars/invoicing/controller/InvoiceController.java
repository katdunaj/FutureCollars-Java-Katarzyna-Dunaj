package pl.futurecollars.invoicing.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.service.InvoicingService;

@RestController
@RequestMapping("invoices")
@RequiredArgsConstructor

class InvoiceController {

    private final InvoicingService invoiceService;

    @GetMapping

    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @PostMapping
    public Invoice add(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }


    @GetMapping
    public ResponseEntity<Invoice> getById(@PathVariable int id) {
        return ResponseEntity.ok(invoiceService.getById(id));

    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(invoiceService.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.update(invoice));
    }

}