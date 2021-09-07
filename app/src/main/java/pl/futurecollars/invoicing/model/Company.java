package pl.futurecollars.invoicing.model;

import java.util.UUID;

public class Company {
    private UUID id;
    private long taxIdentificationNumber;
    private String address;

    public Company(final int id, long taxIdentificationNumber, String address) {
        this.id = UUID.randomUUID();
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.address = address;
    }
}