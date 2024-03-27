package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Categorie;
import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Exceptions.ResourceNotFoundException;
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

@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<Circuit> updateCircuit
            (@PathVariable(value = "id") Long id_circuit, @Valid @RequestBody CircuitDto circuitDto)
            throws ResourceNotFoundException{
        Circuit circuit = circuitRepository.findById(id_circuit).orElseThrow
                (() -> new ResourceNotFoundException("Pas de categorie avec cet id"));
        // Update the existing circuit with the new data
        if (circuitDto.getNom() != null) {
            circuit.setNom(circuitDto.getNom());
        }

        if (circuitDto.getCategories() != null) {
            circuit.setCategories(circuitDto.getCategories());
        }

        if (circuitDto.getDate() != null) {
            circuit.setDate(circuitDto.getDate());
        }

        if (circuitDto.getDestination() != null) {
            circuit.setDestination(circuitDto.getDestination());
        }

        if (circuitDto.getDifficulte() != -1) {
            circuit.setDifficulte(circuitDto.getDifficulte());
        }

        if (circuitDto.getDuree() != null) {
            circuit.setDuree(circuitDto.getDuree());
        }

        // Save the updated circuit
        Circuit updatedCircuit = circuitRepository.save(circuit);

        return ResponseEntity.ok(updatedCircuit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCircuitById(@PathVariable(value = "id")Long id_circuit)
        throws ResourceNotFoundException{
        Circuit circuit = circuitRepository.findById(id_circuit).orElseThrow
                (() -> new ResourceNotFoundException("Aucun circuit avec cet id" + id_circuit));
        circuitRepository.delete(circuit);
        return ResponseEntity.ok().body("Circuit Supprimer");
    }
}
