package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Agence;
import com.medianet.AgenceApplication.Repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
