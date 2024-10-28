package org.example.parcial1.Controllers;

import org.example.parcial1.DTO.DnaRequest;
import org.example.parcial1.DTO.DnaResponse;
import org.example.parcial1.Services.StatsService;
import org.example.parcial1.Services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @Autowired
    private StatsService statsServices;

    @PostMapping("")
    public ResponseEntity<?> isMutant(@RequestBody DnaRequest dnaRequest) {
        // Llama al servicio para guardar el ADN y determinar si es mutante.
        boolean isMutant = dnaService.saveDna(dnaRequest.getDna());

        // Crea una respuesta DnaResponse con el resultado.
        DnaResponse dnaResponse = new DnaResponse(isMutant);

        // Si el ADN es mutante, devuelve una respuesta con el estado HTTP OK.
        if (isMutant) {
            return new ResponseEntity<>("Mutant detected", HttpStatus.OK);
        } else {
            // Si el ADN no es mutante, devuelve una respuesta con el estado HTTP FORBIDDEN.
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
        }
    }

}
