package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "agences")
public class Agence extends User implements Serializable{
    private String nom;
    private String description;
    private String email;
    private String specialite;
    private String adresse;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
