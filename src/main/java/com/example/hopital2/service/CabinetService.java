package com.example.hopital2.service;

import com.example.hopital2.dto.ImputMedecinDto;

public interface CabinetService {

    Integer ajouterCabinet(String adress);

    Boolean ajouterNouveauMedecin(Integer id_cabinet, ImputMedecinDto dto);

    Boolean ajouterMedecin(Integer id_cabinet, Integer id_medecin);

    Boolean exist (Integer id);

    void supprimer(Integer id);
}
