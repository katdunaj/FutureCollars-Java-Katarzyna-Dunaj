package pl.futurecollars.invoicing.model;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Company {
    private UUID id;
    private long TaxIdentificationNumber;
    private String address;

    public Company(final int id, long taxIdentificationNumber, String address) {
        this.id = UUID.randomUUID();
        this.TaxIdentificationNumber = taxIdentificationNumber;
        this.address = address;
    }
}