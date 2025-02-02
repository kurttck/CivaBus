package com.civa.retotecnico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bus")
    private UUID id;
    private Integer busNumber;

    @Column(unique = true)
    private String plate;
    private LocalDate creationDate;
    private String features;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;

    private Boolean status;
}
