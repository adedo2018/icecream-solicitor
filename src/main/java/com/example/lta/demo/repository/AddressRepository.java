package com.example.lta.demo.repository;

import com.example.lta.demo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository <Address, Long>{

    Optional<Address> findById(Long id);
}
