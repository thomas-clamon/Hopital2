package com.example.hopital2.Repository;

import com.example.hopital2.Entity.CabinetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepository extends JpaRepository<CabinetEntity, Integer> {
}