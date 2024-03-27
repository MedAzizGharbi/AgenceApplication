package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Circuit;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class AgenceDto {
    private String nom;
    private String description;
    private String email;
    private String specialite;
    private String adresse;
    private Set<Circuit> circuits;

}
