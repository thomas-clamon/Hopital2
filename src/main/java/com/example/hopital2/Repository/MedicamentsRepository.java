package com.example.hopital2.Repository;

import com.example.hopital2.Entity.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentsRepository extends JpaRepository<MedicamentEntity, Integer> {
    int countDistinctByType(String type);

}
