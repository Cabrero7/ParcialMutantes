package org.example.parcial1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DnaResponse {

    private  boolean isMutant;

    public boolean isMutant() {
        return isMutant;
    }

}
