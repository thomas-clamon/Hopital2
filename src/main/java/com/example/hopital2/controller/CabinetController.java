package com.example.hopital2.controller;

import com.example.hopital2.dto.ImputMedecinDto;
import com.example.hopital2.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("Cabinet")
public class CabinetController {

    @Autowired
    private CabinetService service;

    @GetMapping("add")
    public ResponseEntity ajouter(@RequestParam String adress) {

        if (adress.length() > 50){
            return new ResponseEntity<> ("l'adresse ne peut pas depasser 50 caracteres",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.ajouterCabinet(adress), HttpStatus.OK);
    }

    @PostMapping("addnewMedeIcin/{id}")
    public ResponseEntity addNewMedecin(@PathVariable String id, @RequestBody ImputMedecinDto dto){

        // on verifie si on peut covertie l'id en int
        Integer ID = null;
        try {
            ID = Integer.parseInt(id);
        }
        catch (Exception e){
            return new ResponseEntity<> ("le format de l'id est incorrect ",HttpStatus.BAD_REQUEST);
        }
        // on verfie si l'id du cabinet existe
        if (!service.exist(ID)){
            return new ResponseEntity<> ("le cabinet n'existe pas",HttpStatus.BAD_REQUEST);
        }
        // on verifie que la date de naissance est au bon format
        try {
            LocalDate.parse(dto.getDateNaissance());
        } catch (DateTimeParseException dt){
            return new ResponseEntity<> ("la date n'a pas le bon format",HttpStatus.BAD_REQUEST);
        }
        service.ajouterNouveauMedecin(ID, dto);
        return new ResponseEntity<> ("le medecin a bien été créé et ajouter",HttpStatus.OK);

    }

    @GetMapping("addMedecin")
    public ResponseEntity addMedecin(@RequestParam Integer id_cabinet, @RequestParam Integer id_medecin){
        // on verfie si l'id du cabinet existe
        if (!service.exist(id_cabinet)){
            return new ResponseEntity<> ("le cabinet n'existe pas",HttpStatus.BAD_REQUEST);
        }
        service.ajouterMedecin(id_cabinet, id_medecin);
        return new ResponseEntity<> ("le medecin n° "+id_medecin+ " a été ajouté",HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity suppCabinet(@PathVariable String id){

        // on verifie si on peut covertie l'id en int
        Integer ID = null;
        try {
            ID = Integer.parseInt(id);
        }
        catch (Exception e){
            return new ResponseEntity<> ("le format de l'id est incorrect ",HttpStatus.BAD_REQUEST);
        }
        // on verfie si l'id du cabinet existe
        if (!service.exist(ID)){
            return new ResponseEntity<> ("le cabinet n'existe pas",HttpStatus.BAD_REQUEST);
        }
        service.supprimer(ID);
        return new ResponseEntity<> ("le cabinet a été supprimer",HttpStatus.BAD_REQUEST);

    }
}
