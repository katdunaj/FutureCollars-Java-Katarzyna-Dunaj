package pl.futurecollars.invoicing.model;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Company {
    private UUID id;
    private long TaxIdentificationNumber;
    private String address;

    public Company(final int id, long TaxIdentificationNumber, String address) {
        this.id = UUID.randomUUID();
        this.TaxIdentificationNumber = TaxIdentificationNumber;
        this.address = address;
    }
}