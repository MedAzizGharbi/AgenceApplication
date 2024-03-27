package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Circuit;
import lombok.Data;

import java.util.Set;

@Data
public class CategorieDto {
    private Long id;
    private String nom;
    private String description;
    private Set<Circuit> circuits;
}
