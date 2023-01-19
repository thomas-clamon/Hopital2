package com.example.hopital2.dto;

public class MedicamentDto {

    private String nom;
    private String type;

    private String date_peremption;


    public String getDate_peremption() {
        return date_peremption;
    }

    public void setDate_peremption(String date_peremption) {
        this.date_peremption = date_peremption;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
