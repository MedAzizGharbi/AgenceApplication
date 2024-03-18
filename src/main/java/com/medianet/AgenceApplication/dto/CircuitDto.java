package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Agence;
import com.medianet.AgenceApplication.Entities.Categorie;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CircuitDto {
    private Long id;
    private String nom;
    private Set<Categorie> categories;
    private Date date;
    private String destination;
    private int difficulte;
    private String duree;
}
