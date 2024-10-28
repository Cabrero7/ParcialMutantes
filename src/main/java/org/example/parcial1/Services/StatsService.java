package org.example.parcial1.Services;


import org.example.parcial1.DTO.StatsResponse;
import org.example.parcial1.Repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    // Inyección de dependencia del repositorio DnaRepository a través del constructor.
    private final DnaRepository dnaRepository;

    // Constructor que recibe una instancia de DnaRepository y la asigna a la variable de instancia.
    @Autowired
    public StatsService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    // Metodo que obtiene las estadísticas de ADN mutante y humano.
    public StatsResponse getStats() {
        // Contar el número de secuencias de ADN mutante.
        long countMutantDna = dnaRepository.countByIsMutant(true);

        // Contar el número de secuencias de ADN humano.
        long countHumanDna = dnaRepository.countByIsMutant(false);

        // Calcular la proporción de ADN mutante a ADN humano.
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        // Devolver una respuesta con las estadísticas.
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}