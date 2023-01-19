package com.example.hopital2.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "Cabinet")
public class CabinetEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "adresse")
    private String adress;

    @OneToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "idcabinet")
    private List<MedecinEntity> listMedecin;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<MedecinEntity> getListMedecin() {
        return listMedecin;
    }

    public void setListMedecin(List<MedecinEntity> listMedecin) {
        this.listMedecin = listMedecin;
    }
}
