package com.example.hopital2.service;

import com.example.hopital2.Entity.CabinetEntity;
import com.example.hopital2.Entity.MedecinEntity;
import com.example.hopital2.Repository.CabinetRepository;
import com.example.hopital2.Repository.MedecinRepository;
import com.example.hopital2.dto.ImputMedecinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CabinetServiceImpl implements CabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Integer ajouterCabinet(String adress) {

        CabinetEntity entity = new CabinetEntity();
        entity.setAdress(adress);
        cabinetRepository.saveAndFlush(entity);

        return entity.getID();
    }

    @Override
    public Boolean ajouterNouveauMedecin(Integer id_cabinet, ImputMedecinDto dto) {

        // on parse la date de naissance
        LocalDate date = LocalDate.parse(dto.getDateNaissance());

        // on creer une entité a partir du DTO
        MedecinEntity entity = new MedecinEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDateNaissance(date);

        // on recupere le cabinet
        CabinetEntity cabinet = cabinetRepository.findById(id_cabinet).get();

        entity.setCabinet(cabinet);

        medecinRepository.saveAndFlush(entity);

        return true;

    }

    @Override
    public Boolean ajouterMedecin(Integer id_cabinet, Integer id_medecin) {

        // on recupere l'entité medecin
        MedecinEntity entity = medecinRepository.findById(id_medecin).get();

        // on recupere l'entité cabinet
        CabinetEntity cabinetEntity = cabinetRepository.findById(id_cabinet).get();
        cabinetEntity.getListMedecin().add(entity);
        cabinetRepository.saveAndFlush(cabinetEntity);
        return true;

    }

    @Override
    public Boolean exist(Integer id) {
        return cabinetRepository.existsById(id);
    }

    @Override
    public void supprimer(Integer id) {

        // on recupere le cabinet
        CabinetEntity cabinetEntity = cabinetRepository.findById(id).get();
        // recuperer sa liste de medecin
        // on va parcourir cette liste pour enlever l'id du cabinet de chaque medecin
        for (int i = 0; i<cabinetEntity.getListMedecin().size(); i++){
            MedecinEntity entity = cabinetEntity.getListMedecin().get(i);
            entity.setCabinet(null);
            medecinRepository.saveAndFlush(entity);
        }

        // on va supprimmer le cabinet
        cabinetRepository.deleteById(id);
    }
}
