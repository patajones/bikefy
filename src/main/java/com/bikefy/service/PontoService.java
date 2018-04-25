package com.bikefy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikefy.entity.Ponto;
import com.bikefy.repository.PontoRepository;

@Service
public class PontoService {
	@Autowired
	private PontoRepository repo;
	
	public List<Ponto> findAll() {
		return repo.findAll();
	}
	
	public Optional<Ponto> find(Integer id) {
		Optional<Ponto> obj = repo.findById(id);
		return obj;
	}	
}
