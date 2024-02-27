package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/circuits")
public class CircuitController {
    @Autowired
    private CircuitRepository circuitRepository;

    @GetMapping
    public List<Circuit> getAllCircuits(){
        return circuitRepository.findAll();
    }
}
