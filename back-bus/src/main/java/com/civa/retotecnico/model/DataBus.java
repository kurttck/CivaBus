package com.civa.retotecnico.model;

import java.time.LocalDate;
import java.util.UUID;

public record DataBus(
    UUID id,
    Integer busNumber,
    String plate,
    LocalDate creationDate,
    String features,
    Brand brand,
    Boolean status
) {


    public DataBus(Bus bus) {
        this(bus.getId(), bus.getBusNumber(), bus.getPlate(), bus.getCreationDate(),
                bus.getFeatures(), bus.getBrand(), bus.getStatus());
    }
}
