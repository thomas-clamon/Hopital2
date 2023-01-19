package com.example.hopital2.service;

import com.example.hopital2.Entity.MedicamentEntity;
import com.example.hopital2.Enum.Type_Medicament;
import com.example.hopital2.Repository.MedicamentsRepository;
import com.example.hopital2.dto.MedicamentDto;
import com.example.hopital2.dto.MedicamentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MedicamentServiceImpl implements MedicamentService{

    @Autowired
    public MedicamentsRepository medicamentsRepository;
    @Override
    public MedicamentTypeDTO countType() {
        MedicamentTypeDTO dto = new MedicamentTypeDTO();

        dto.setPiqure(medicamentsRepository.countDistinctByType(Type_Medicament.PIQUURE.toString()));
        dto.setPommade(medicamentsRepository.countDistinctByType(Type_Medicament.POMMADE.toString()));
        dto.setCachet(medicamentsRepository.countDistinctByType(Type_Medicament.CACHET.toString()));
        dto.setSirop(medicamentsRepository.countDistinctByType(Type_Medicament.SIROP.toString()));


        return dto;

    }

    @Override
    public MedicamentDto entityToDto(MedicamentEntity entity) {

        MedicamentDto dto = new MedicamentDto();
        dto.setDate_peremption(entity.getPeremption().toString());
        dto.setNom(entity.getNom());
        dto.setType(entity.getType());

        return dto;
    }

    @Override
    public MedicamentTypeDTO countOutDatedByType() {


        LocalDate today = LocalDate.now();

        MedicamentTypeDTO dto = new MedicamentTypeDTO();

        dto.setPiqure(medicamentsRepository.countDistinctByPeremptionBeforeAndType(today, Type_Medicament.PIQUURE.toString()));
        dto.setPommade(medicamentsRepository.countDistinctByPeremptionBeforeAndType(today, Type_Medicament.POMMADE.toString()));
        dto.setCachet(medicamentsRepository.countDistinctByPeremptionBeforeAndType(today, Type_Medicament.CACHET.toString()));
        dto.setSirop(medicamentsRepository.countDistinctByPeremptionBeforeAndType(today, Type_Medicament.SIROP.toString()));

        return dto;
    }
}
