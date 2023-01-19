package com.example.hopital2.Repository;

import com.example.hopital2.Entity.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicamentsRepository extends JpaRepository<MedicamentEntity, Integer> {
    int countDistinctByType(String type);


    int countDistinctByPeremptionBeforeAndType(LocalDate date, String type);



    List<MedicamentEntity> findAllByPeremptionBefore(LocalDate date);

    List<MedicamentEntity> findByOrderByPeremptionDesc();

    MedicamentEntity findFirstByOrderByPeremptionDesc();



}
