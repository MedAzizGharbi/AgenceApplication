package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "agences")
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private List<Circuit> circuitList;
    private String description;
    private String email;

    public Agence() {
    }

    public Agence(String nom, List<Circuit> circuitList, String description, String email) {
        this.nom = nom;
        this.circuitList = circuitList;
        this.description = description;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Circuit> getCircuitList() {
        return circuitList;
    }

    public void setCircuitList(List<Circuit> circuitList) {
        this.circuitList = circuitList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}