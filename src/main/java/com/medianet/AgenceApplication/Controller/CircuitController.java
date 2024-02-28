package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Circuit;
import com.medianet.AgenceApplication.Repository.CircuitRepository;
import com.medianet.AgenceApplication.dto.CircuitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("create")
    public ResponseEntity<Circuit> createCircuit(@Valid @RequestBody Circuit circuit){
        Circuit savedCircuit = circuitRepository.save(circuit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCircuit);
    }
}
