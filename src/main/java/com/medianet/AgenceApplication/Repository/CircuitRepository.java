package com.medianet.AgenceApplication.Repository;

import com.medianet.AgenceApplication.Entities.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit , Long> {
    void delete(Optional<Circuit> existingCircuit);
}
