package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<Circuit> circuits;

    public Categorie() {
    }

    public Categorie(String nom, String description, Set<Circuit> circuits) {
        this.nom = nom;
        this.description = description;
        this.circuits = circuits;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(Set<Circuit> circuits) {
        this.circuits = circuits;
    }
}
