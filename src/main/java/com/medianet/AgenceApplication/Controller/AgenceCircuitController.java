package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.AgenceCircuit;
import com.medianet.AgenceApplication.Repository.AgenceCircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agence_circuits")
public class AgenceCircuitController {
    @Autowired
    private AgenceCircuitRepository agenceCitcuitRepository;
    @GetMapping
    public List<AgenceCircuit> getAllAgenceCircuit(){
        return agenceCitcuitRepository.findAll();
    }
}
