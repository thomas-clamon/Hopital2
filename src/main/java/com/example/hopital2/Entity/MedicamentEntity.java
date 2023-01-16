package com.example.hopital2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicaments")
public class MedicamentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Type")
    private String Type;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
