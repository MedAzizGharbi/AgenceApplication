package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="circuits")
public class Circuit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToMany
    @JoinTable(
            name = "circuit_categorie",
            joinColumns = @JoinColumn(name = "circuit_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    private Set<Categorie> categories;

    private Date date;
    private String destination;
    private int difficulte;
    private String duree;
    @ManyToMany(mappedBy = "circuits")
    private Set<Agence> agences;
    public Circuit(){

    }

    public Circuit(String nom, Set<Categorie> categories, Date date, String destination, int difficulte, String duree, Set<Agence> agences) {
        this.nom = nom;
        this.categories = categories;
        this.date = date;
        this.destination = destination;
        this.difficulte = difficulte;
        this.duree = duree;
        this.agences = agences;
    }

    public Set<Agence> getAgences() {
        return agences;
    }

    public void setAgences(Set<Agence> agences) {
        this.agences = agences;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Set<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categorie> categories) {
        this.categories = categories;
    }

}
