package com.example.hopital2.service;

import com.example.hopital2.Enum.Type_Medicament;
import com.example.hopital2.Repository.MedicamentsRepository;
import com.example.hopital2.dto.MedicamentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
