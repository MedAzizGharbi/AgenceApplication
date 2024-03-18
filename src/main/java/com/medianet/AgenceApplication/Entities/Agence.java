package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "agences")
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    private String description;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "agence_circuit",
            joinColumns = @JoinColumn(name = "agence_id"),
            inverseJoinColumns = @JoinColumn(name = "circuit_id")
    )
    private Set<Circuit> circuits;

    public Agence() {
    }

    public Set<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(Set<Circuit> circuits) {
        this.circuits = circuits;
    }

    public Agence(String nom, String description, String email) {
        this.nom = nom;
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
