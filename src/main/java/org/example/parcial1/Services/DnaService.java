package org.example.parcial1.Services;

import org.example.parcial1.Entities.Dna;
import org.example.parcial1.Repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class DnaService {

    //Inyección de dependencia del repositorio DnaRepository.
    @Autowired
    private DnaRepository dnaRepository;

    // Metodo que determina si una secuencia de ADN es mutante.
    public boolean isMutant(String[] dna) {

        int sequenceCount = 0;
        int size = dna.length;

        sequenceCount += checkAllHorizontal(dna, size);
        sequenceCount += checkAllVertical(dna, size);
        sequenceCount += checkAllDiagonals(dna, size);

        return sequenceCount > 1;

    }

    // Metodo que verifica secuencias horizontales en la matriz de ADN.
    private int checkAllHorizontal(String[] dna, int size) {
        return IntStream.range(0, size)
                .map(i -> checkSequence(dna[i]))
                .sum();
    }

    // Metodo que verifica secuencias verticales en la matriz de ADN.
    private int checkAllVertical(String[] dna, int size) {
        return IntStream.range(0, size)
                .map(j -> {
                    StringBuilder column = new StringBuilder();
                    IntStream.range(0, dna.length)
                            .forEach(i -> column.append(dna[i].charAt(j)));
                    return checkSequence(column.toString());
                })
                .sum();
    }

    // Metodo que verifica secuencias diagonales en la matriz de ADN.
    private int checkAllDiagonals(String[] dna, int size) {

        int leftToRightDiagonals = IntStream.range(0, size)
                .map(i -> {
                    StringBuilder diagonal = new StringBuilder();
                    IntStream.range(0, i + 1)
                            .filter(j -> i - j < size)
                            .forEach(j -> diagonal.append(dna[i - j].charAt(j)));
                    return checkSequence(diagonal.toString());
                })
                .sum();

        int rightToLeftDiagonals = IntStream.range(0, size)
                .map(i -> {
                    StringBuilder diagonal = new StringBuilder();
                    IntStream.range(0, i + 1)
                            .filter(j -> i - j < size)
                            .forEach(j -> diagonal.append(dna[i - j].charAt(size - 1 - j)));
                    return checkSequence(diagonal.toString());
                })
                .sum();

        return leftToRightDiagonals + rightToLeftDiagonals;
    }

    // Metodo que verifica si una secuencia contiene una racha de 4 caracteres iguales.
    private int checkSequence(String sequence) {
        int count = 0;
        char currentChar = sequence.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentChar) {
                currentStreak++;
                if (currentStreak == 4) {
                    count++;
                    currentStreak = 0;
                }
            } else {
                currentChar = sequence.charAt(i);
                currentStreak = 1;
            }
        }

        return count;
    }

    // Metodo que guarda una secuencia de ADN y determina si es mutante.
    public boolean saveDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);

        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant(dna);
    }
}
