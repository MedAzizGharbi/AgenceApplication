package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Categorie;
import com.medianet.AgenceApplication.Exceptions.ResourceNotFoundException;
import com.medianet.AgenceApplication.Repository.CategorieRepository;
import com.medianet.AgenceApplication.dto.CategorieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;
    @GetMapping
    public List<Categorie> getAllCategories(){return categorieRepository.findAll();}
    @PostMapping("/add")
    public ResponseEntity<String> addCategorie(@Valid @RequestBody CategorieDto categorieDto){
        Categorie categorie = new Categorie
                (categorieDto.getNom(),categorieDto.getDescription(),categorieDto.getCircuits());
        Categorie savedCategorie = categorieRepository.save(categorie);
        return ResponseEntity.ok().body("Categorie ajoutée");
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editCategorie(@PathVariable(value = "id")Long id_categorie,
                                                @Valid @RequestBody CategorieDto categorieDto)
        throws ResourceNotFoundException{
        Categorie categorie = categorieRepository.findById(id_categorie).orElseThrow
                (() -> new ResourceNotFoundException("Pas de categorie avec cet id"));
        if(categorieDto.getNom() != null){categorie.setNom(categorieDto.getNom());}
        if(categorieDto.getDescription() != null){categorie.setDescription(categorieDto.getDescription());}
        if(categorieDto.getCircuits() != null){categorie.setCircuits(categorieDto.getCircuits());}

        Categorie savedCategorie = categorieRepository.save(categorie);
        return ResponseEntity.ok().body("Categorie Modifiée");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategorieById(@PathVariable(value = "id")Long id_categorie)
        throws ResourceNotFoundException{
        Categorie categorie = categorieRepository.findById(id_categorie).orElseThrow
                (() -> new ResourceNotFoundException("Pas de categorie avec cet id"));
        categorieRepository.delete(categorie);
        return ResponseEntity.ok().body("Categorie Effacée");
    }

}
