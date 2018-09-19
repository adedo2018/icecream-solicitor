package com.example.lta.demo.repository;

import com.example.lta.demo.domain.Solicitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolicitorRepository extends JpaRepository <Solicitor, Long>{
    Optional<Solicitor> findByName(String name);
}
