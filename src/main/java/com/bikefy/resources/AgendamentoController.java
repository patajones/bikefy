package com.bikefy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bikefy.dto.AgendamentoDTO;
import com.bikefy.entity.Agendamento;
import com.bikefy.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> findAll() {		
		List<Agendamento> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.POST })
	public ResponseEntity<Void> insert(@RequestBody AgendamentoDTO objDto) {		
		service.insere(objDto);		
		return ResponseEntity.ok().build();
	}
    
}
