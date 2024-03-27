package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Avis;
import com.medianet.AgenceApplication.Exceptions.ResourceNotFoundException;
import com.medianet.AgenceApplication.Repository.AvisRepository;
import com.medianet.AgenceApplication.dto.AvisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/avis")
public class AvisController {
    @Autowired
    private AvisRepository avisRepository;

    @GetMapping
    public List<Avis> getAllAvis(){return avisRepository.findAll();}
    @PostMapping("/add")
    public ResponseEntity<Avis> addAvis(@Valid @RequestBody Avis avis){
        Avis savedAvis = avisRepository.save(avis);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editAvis
            (@PathVariable(value = "id") Long id_avis,@Valid @RequestBody AvisDto avisDetails)
            throws ResourceNotFoundException{
        Avis avis = avisRepository.findById(id_avis).orElseThrow
                (() -> new ResourceNotFoundException("Avis n'existe pas avec cet id" + id_avis));
        avis.setClient(avisDetails.getClient());
        avis.setCircuit(avisDetails.getCircuit());
        avis.setCommentaire(avisDetails.getCommentaire());
        avis.setDate(avisDetails.getDate());
        avis.setNote(avisDetails.getNote());
        final Avis updatedAvis = avisRepository.save(avis);
        return ResponseEntity.ok().body("Avis modifié");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAvisById(@PathVariable(value = "id")Long id_avis)
            throws ResourceNotFoundException{
        Avis avis = avisRepository.findById(id_avis).orElseThrow
                (() -> new ResourceNotFoundException("Avis n'existe pas avec cet id" + id_avis));
        avisRepository.delete(avis);
        return ResponseEntity.ok().body("Avis Supprimé");
    }
}
