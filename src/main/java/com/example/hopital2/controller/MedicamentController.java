package com.example.hopital2.controller;

import com.example.hopital2.Entity.MedicamentEntity;
import com.example.hopital2.Enum.Type_Medicament;
import com.example.hopital2.Repository.MedicamentsRepository;
import com.example.hopital2.dto.MedicamentDto;
import com.example.hopital2.dto.MedicamentTypeDTO;
import com.example.hopital2.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentsRepository repository;

    @Autowired
    private MedicamentService medicamentService;

    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody MedicamentDto dto) {

        try {
            Type_Medicament type = Type_Medicament.valueOf(dto.getType());
        } catch (Exception e) {
            return new ResponseEntity("le type n'est pas correct", HttpStatus.BAD_REQUEST);
        }
        MedicamentEntity entity = new MedicamentEntity();
        entity.setNom(dto.getNom());
        entity.setType(dto.getType());

        repository.saveAndFlush(entity);

        return new ResponseEntity(entity.getID(), HttpStatus.OK);

    }


    @GetMapping("details")
    public ResponseEntity exemple(){
        return new ResponseEntity(medicamentService.countType(), HttpStatus.OK);
    }
}