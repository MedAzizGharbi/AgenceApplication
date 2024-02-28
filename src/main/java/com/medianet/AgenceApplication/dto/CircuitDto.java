package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Agence;
import lombok.Data;

import java.util.Date;

@Data
public class CircuitDto {
    private Long id;
    private String nom;
    private String categorie;
    private Date date;
    private String destination;
    private int difficulte;
    private String duree;
}
