package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Agence;
import com.medianet.AgenceApplication.Repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    @Autowired
    private AgenceRepository agenceRepository;

    @GetMapping
    public List<Agence> getAllAgences(){
        return agenceRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Agence> addAgence(@Valid @RequestBody Agence agence){
        Agence savedAgence = agenceRepository.save(agence);
        return ResponseEntity.ok().build();
    }
}
