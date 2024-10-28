package org.example.parcial1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DnaResponse {

    // Campo que indica si el ADN es mutante.
    private boolean isMutant;

    // Metodo getter para el campo isMutant.
    public boolean isMutant() {
        return isMutant;
    }

}
