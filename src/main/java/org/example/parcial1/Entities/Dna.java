package org.example.parcial1.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Dna extends Base implements Serializable {

    // Campo que representa la secuencia de ADN.
    @Column(name = "DNA")
    private String dna;

    // Campo que indica si el ADN es mutante.
    private boolean isMutant;

}
