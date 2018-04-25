package com.bikefy.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bikefy.entity.Ponto;
import com.bikefy.repository.PontoRepository;

@RestController
@RequestMapping("/ponto")
public class PontoController {
	
	@Autowired
	private PontoRepository pontoRepository;
        
	@GetMapping
	public ResponseEntity<List<Ponto>> findAll() {		
		List<Ponto> list = pontoRepository.findAll();		
		return ResponseEntity.ok().body(list);
	}
	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Ponto>> find(@PathVariable Integer id) {		
		Optional<Ponto> ponto = pontoRepository.findById(id);		
		return ResponseEntity.ok().body(ponto);
	}
    
}
