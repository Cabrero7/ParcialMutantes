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
        boolean isMutant = dnaService.saveDna(dnaRequest.getDna());
        DnaResponse dnaResponse = new DnaResponse(isMutant);
        if (isMutant) {
            return new ResponseEntity<>("Mutant detected", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
        }
    }

}
