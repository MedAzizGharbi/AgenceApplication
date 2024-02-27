package com.medianet.AgenceApplication.dto;

import com.medianet.AgenceApplication.Entities.Circuit;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class AgenceDto {
    private Long id;
    private String nom;
    private List<Circuit> circuitList;
    private String description;
    private String email;
}
