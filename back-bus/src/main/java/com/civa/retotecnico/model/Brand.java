package com.civa.retotecnico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_brand")
    private UUID id;

    @Column(unique = true)
    private String name;
}
