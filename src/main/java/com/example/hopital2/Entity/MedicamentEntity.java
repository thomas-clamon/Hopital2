package com.example.hopital2.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Medicaments")
public class MedicamentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "type")
    private String type;

    @Column(name = "peremption")
    private LocalDate peremption;





    public LocalDate getPeremption() {
        return peremption;
    }

    public void setPeremption(LocalDate peremption) {
        this.peremption = peremption;
    }

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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
