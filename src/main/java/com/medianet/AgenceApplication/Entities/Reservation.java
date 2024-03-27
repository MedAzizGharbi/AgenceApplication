package com.medianet.AgenceApplication.Entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    private Date date;
    private boolean statusPaiement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatusPaiement() {
        return statusPaiement;
    }

    public void setStatusPaiement(boolean statusPaiement) {
        this.statusPaiement = statusPaiement;
    }
}
