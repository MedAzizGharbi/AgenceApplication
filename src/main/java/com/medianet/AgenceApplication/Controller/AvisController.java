package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Avis;
import com.medianet.AgenceApplication.Repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}
