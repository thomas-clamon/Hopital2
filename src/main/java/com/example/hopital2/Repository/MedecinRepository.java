package com.example.hopital2.Repository;

import com.example.hopital2.Entity.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<MedecinEntity, Integer> {
}
