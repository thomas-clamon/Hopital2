package com.example.hopital2.controller;

import com.example.hopital2.Entity.MedicamentEntity;
import com.example.hopital2.Enum.Type_Medicament;
import com.example.hopital2.Repository.MedecinRepository;
import com.example.hopital2.Repository.MedicamentsRepository;
import com.example.hopital2.dto.MedicamentDto;
import com.example.hopital2.dto.MedicamentTypeDTO;
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

    @GetMapping("Details")
    public ResponseEntity<MedicamentTypeDTO> details() {

        MedicamentTypeDTO dto = new MedicamentTypeDTO();

        int cachet = 0;
        int piqure = 0;
        int pommade = 0;
        // Recuperer tous les medicaments
        List<MedicamentEntity> list = repository.findAll();

        for (int i = 0; i < list.size(); i++) {

            if ( Type_Medicament.valueOf(list.get(i).getType()).equals(Type_Medicament.PIQUURE))
                piqure++;
            if (Type_Medicament.valueOf(list.get(i).getType()).equals(Type_Medicament.POMMADE))
                pommade++;
            if ( Type_Medicament.valueOf(list.get(i).getType()).equals(Type_Medicament.CACHET))
                cachet++;
        }
        dto.setCachet(cachet);
        dto.setPiqure(piqure);
        dto.setPommade(pommade);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}