package org.example.parcial1.Repositories;

import org.example.parcial1.Entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    // Metodo que busca una entidad Dna por su campo dna.
    Optional<Dna> findByDna(String dna);

    // Metodo que cuenta el número de entidades Dna que tienen el campo isMutant igual al valor especificado.
    long countByIsMutant(Boolean isMutant);

}
