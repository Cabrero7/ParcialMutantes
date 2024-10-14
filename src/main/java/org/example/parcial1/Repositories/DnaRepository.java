package org.example.parcial1.Repositories;

import org.example.parcial1.Entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
    Optional<Dna> findByDna(String dna);
    long countByIsMutant(Boolean isMutant);
}
