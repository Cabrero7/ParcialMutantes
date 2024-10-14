package org.example.parcial1.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.parcial1.Validations.ValidDna;

@Getter
@Setter
public class DnaRequest {

    @ValidDna
    private String[] dna;

}
