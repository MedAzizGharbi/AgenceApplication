package com.medianet.AgenceApplication.Controller;

import com.medianet.AgenceApplication.Entities.Categorie;
import com.medianet.AgenceApplication.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;
    @GetMapping
    public List<Categorie> getAllCategories(){return categorieRepository.findAll();}

}
