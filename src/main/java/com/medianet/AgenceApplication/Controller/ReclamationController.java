package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Reclamation;
import com.medianet.AgenceApplication.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {
    @Autowired
    private ReclamationRepository reclamationRepository;

    @GetMapping
    public List<Reclamation> getAllReclamations(){return reclamationRepository.findAll();}
}
