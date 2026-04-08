package com.example.demo.repository;

import com.example.demo.model.AvisoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisoRepository extends JpaRepository<AvisoModel, Long> {
}
