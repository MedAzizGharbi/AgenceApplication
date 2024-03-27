package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client extends User implements Serializable {
    private String nom;
    private String prenom;
    private String preferences;
    private String historique;
    private Long cin;
    private Long age;

    public Client(String nom, String prenom, String preferences, String historique, Long cin, Long age) {
        this.nom = nom;
        this.prenom = prenom;
        this.preferences = preferences;
        this.historique = historique;
        this.cin = cin;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
