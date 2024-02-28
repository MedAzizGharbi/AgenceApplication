package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Repository.CircuitRepository;
import com.medianet.AgenceApplication.dto.CircuitDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/circuits")
public class CircuitController {
    @Autowired
    private CircuitRepository circuitRepository;

    @GetMapping
    public List<Circuit> getAllCircuits(){
        return circuitRepository.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<Circuit> createCircuit(@Valid @RequestBody Circuit circuit){
        Circuit savedCircuit = circuitRepository.save(circuit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCircuit);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Circuit> updateCircuit(@PathVariable Long id, @Valid @RequestBody CircuitDto circuitDto){
        Circuit existingCircuit = null;
        try {
            existingCircuit = circuitRepository.findById(id)
                    .orElseThrow(() -> new Exception("Circuit not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Update the existing circuit with the new data
        existingCircuit.setNom(circuitDto.getNom());
        existingCircuit.setCategorie(circuitDto.getCategorie());
        existingCircuit.setDate(circuitDto.getDate());
        existingCircuit.setDestination(circuitDto.getDestination());
        existingCircuit.setDifficulte(circuitDto.getDifficulte());
        existingCircuit.setDuree(circuitDto.getDuree());

        // Save the updated circuit
        Circuit updatedCircuit = circuitRepository.save(existingCircuit);

        return ResponseEntity.ok(updatedCircuit);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCircuit(@PathVariable Long id){
        Optional<Circuit> existingCircuit = circuitRepository.findById(id);
        if(existingCircuit.isPresent()){
            circuitRepository.delete(existingCircuit);
            return ResponseEntity.noContent().build();
        }
        return null;
    }
}
