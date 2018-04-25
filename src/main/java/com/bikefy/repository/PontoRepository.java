package com.bikefy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikefy.entity.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Integer> {

}
