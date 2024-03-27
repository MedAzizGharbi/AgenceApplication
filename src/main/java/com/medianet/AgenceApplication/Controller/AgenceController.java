package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Agence;
import com.medianet.AgenceApplication.Exceptions.ResourceNotFoundException;
import com.medianet.AgenceApplication.Repository.AgenceRepository;
import com.medianet.AgenceApplication.dto.AgenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    @Autowired
    private AgenceRepository agenceRepository;

    @GetMapping("/")
    public List<Agence> getAllAgences(){
        return agenceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable(value = "id") Long id_agence)
            throws ResourceNotFoundException{
        Agence agence = agenceRepository.findById(id_agence).orElseThrow
                (() -> new ResourceNotFoundException("Agence not found for this id :: " + id_agence));
        return ResponseEntity.ok().body(agence);
    }
    @PostMapping("/add")
    public ResponseEntity<Agence> addAgence(@Valid @RequestBody Agence agence){
        Agence savedAgence = agenceRepository.save(agence);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Agence> editAgenceById(@PathVariable(value = "id") Long id_agence,
                                                 @Valid @RequestBody AgenceDto agenceDetails) throws ResourceNotFoundException {
        Agence agence = agenceRepository.findById(id_agence).orElseThrow
                (() -> new ResourceNotFoundException("Agence not found for this id :: "+ id_agence));
        if (agenceDetails.getAdresse() != null) {
            agence.setAdresse(agenceDetails.getAdresse());
        }
        if (agenceDetails.getCircuits() != null) {
            agence.setCircuits(agenceDetails.getCircuits());
        }
        if (agenceDetails.getDescription() != null) {
            agence.setDescription(agenceDetails.getDescription());
        }
        if (agenceDetails.getEmail() != null) {
            agence.setEmail(agenceDetails.getEmail());
        }
        if (agenceDetails.getSpecialite() != null) {
            agence.setSpecialite(agenceDetails.getSpecialite());
        }
        final Agence updatedAgence = agenceRepository.save(agence);
        return ResponseEntity.ok(updatedAgence);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAgenceById(@PathVariable(value="id") Long id_agence)
            throws ResourceNotFoundException{
        Agence agence = agenceRepository.findById(id_agence).orElseThrow
                (() -> new ResourceNotFoundException("Agence not found for this id :: "+ id_agence));
        agenceRepository.delete(agence);
        return ResponseEntity.ok().body("Agence effacé");
    }


}
