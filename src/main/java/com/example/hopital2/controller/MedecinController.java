package com.example.hopital2.controller;

import com.example.hopital2.Entity.MedecinEntity;
import com.example.hopital2.Repository.MedecinRepository;
import com.example.hopital2.dto.ImputMedecinDto;
import com.example.hopital2.dto.MedecinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("medecin")
public class MedecinController {

    @Autowired
    private MedecinRepository repository;

    @GetMapping("get/{id}")
    public ResponseEntity<MedecinDto> getDto(@PathVariable String id) {

        // on converti la parametre en entier
        int ID = Integer.parseInt(id);

        // verfier que l'utilisateur existe
        if (!repository.findById(ID).isPresent())
            return new ResponseEntity("L'utilisateur n'existe pas", HttpStatus.NO_CONTENT);
        else
        // on recupere l'entity
        {
            MedecinEntity medecinEntity = repository.findById(ID).get();

            // on converti notre entity en dto

            MedecinDto dto = new MedecinDto();
            dto.setDisplay_name(medecinEntity.getPrenom() + " " + medecinEntity.getNom());

            int Age = Period.between(medecinEntity.getDateNaissance(), LocalDate.now()).getYears();

            dto.setAge(Age);

            return new ResponseEntity(dto, HttpStatus.OK);
        }

    }


    @PostMapping("Add")
    public HttpEntity<Integer> ResponseEntity(@RequestBody ImputMedecinDto dto) {
        LocalDate date = null;

        if (dto.getNom().length() > 15)
            return new ResponseEntity("le nom ne dois pas depasser 15 caracthere", HttpStatus.BAD_REQUEST);

        if (dto.getPrenom().length() > 15)
            return new ResponseEntity("le prenom ne dois pas depasser 15 caracthere", HttpStatus.BAD_REQUEST);

        try {
            date = LocalDate.parse(dto.getDateNaissance(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return new ResponseEntity("la date n'a pas le bon format", HttpStatus.BAD_REQUEST);
        }

        // ici notre dto est correct

        MedecinEntity entity = new MedecinEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDateNaissance(date);

        repository.saveAndFlush(entity);

        return new ResponseEntity<>(entity.getID(), HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Boolean> supprimer(@PathVariable String id) {
        // on converti la parametre en entier
        int ID = Integer.parseInt(id);

        // verfier que l'utilisateur existe
        if (!repository.findById(ID).isPresent())
            return new ResponseEntity("L'utilisateur n'existe pas", HttpStatus.OK);

        repository.deleteById(ID);

        ResponseEntity reponse = new ResponseEntity("l'utilisateur " + ID + "est supprimé", HttpStatus.OK);

        return reponse;
    }


    @PostMapping("update/{id}")
    public ResponseEntity<Integer> ResponseEntity(@RequestBody ImputMedecinDto dto, @PathVariable String id) {

        // on converti la parametre en entier
        int ID = Integer.parseInt(id);

        // verfier que l'utilisateur existe
        if (!repository.findById(ID).isPresent())
            return new ResponseEntity("L'utilisateur n'existe pas", HttpStatus.OK);

        LocalDate date = null;

        if (dto.getNom().length() > 15)
            return new ResponseEntity("le nom ne dois pas depasser 15 caracthere", HttpStatus.BAD_REQUEST);

        if (dto.getPrenom().length() > 15)
            return new ResponseEntity("le prenom ne dois pas depasser 15 caracthere", HttpStatus.BAD_REQUEST);

        try {
            date = LocalDate.parse(dto.getDateNaissance(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return new ResponseEntity("la date n'a pas le bon format", HttpStatus.BAD_REQUEST);
        }


        MedecinEntity entity = repository.findById(ID).get();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDateNaissance(date);

        repository.saveAndFlush(entity);

        return new ResponseEntity("l'utilisateur a été modifier", HttpStatus.OK);

    }
}