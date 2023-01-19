package com.example.hopital2.service;

import com.example.hopital2.Entity.MedicamentEntity;
import com.example.hopital2.dto.MedicamentDto;
import com.example.hopital2.dto.MedicamentTypeDTO;
import org.springframework.stereotype.Service;

public interface MedicamentService {

    MedicamentTypeDTO countType();

    MedicamentDto entityToDto(MedicamentEntity entity);

    MedicamentTypeDTO countOutDatedByType();

}
