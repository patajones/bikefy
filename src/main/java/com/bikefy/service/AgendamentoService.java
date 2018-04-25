package com.bikefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikefy.dto.AgendamentoDTO;
import com.bikefy.entity.Agendamento;
import com.bikefy.repository.AgendamentoRepository;
import com.bikefy.repository.PontoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repo;
	@Autowired
	private PontoRepository ponto_repo;

	public List<Agendamento> findAll() {
		return repo.findAll();
	}
		
	public Agendamento insere(AgendamentoDTO dto) {		
		Agendamento obj = new Agendamento(null, ponto_repo.getOne(dto.getPonto_retirada_id()), ponto_repo.getOne(dto.getPonto_devolucao_id()), dto.getData_retirada(),
				dto.getData_devolucao(), dto.getHora_retirada(), dto.getHora_devolucao());
		return repo.save(obj);
	}
}
