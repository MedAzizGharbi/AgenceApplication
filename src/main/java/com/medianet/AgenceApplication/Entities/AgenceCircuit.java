package com.medianet.AgenceApplication.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "agences_circuits")
public class AgenceCircuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }
}
