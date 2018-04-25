package com.bikefy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.bikefy.entity.Agendamento;
import com.bikefy.entity.Bike;
import com.bikefy.entity.Ponto;
import com.bikefy.repository.AgendamentoRepository;
import com.bikefy.repository.PontoRepository;

@SpringBootApplication
public class BikefyApplication implements CommandLineRunner {

	@Autowired
	private PontoRepository pontoRepository;

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(BikefyApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			Ponto p1 = new Ponto(-15.80981663, -47.86636308, "STJ", "SAFS Quadra 4", 5);
			// Ponto p1 = Ponto.builder().nome("STJ").endereco("SAFS Quadra
			// 4").lat(-15.80981663).lon(-47.86636308).qtd_bikes(5)
			// .agenda(
			// Agendamento.builder().data_retirada(LocalDate.now()).hora_retirada(LocalTime.now()).build())
			// .build();

			pontoRepository.save(p1);

			Ponto p2 = new Ponto(-15.79405451, -47.883804838, "Rodô", "Oeste da Rodoviária do Plano Piloto", 4);
			pontoRepository.save(p2);

			Ponto p3 = new Ponto(-15.76117169, -47.87445579, "UNB", "L3 Norte", 10);
			pontoRepository.save(p3);

			// Ponto p4 = Ponto.builder()
			// .nome("Liberty Mall")
			// .lat(-15.787249709036422).lon(-47.884654889965816)
			// .agendamento(Agendamento.builder()
			// .data_retirada(LocalDate.now())
			// .hora_retirada(LocalTime.now()).build())
			// .build();
			// pontoRepository.save(p4)

			Ponto p5 = Ponto.builder().nome("Liberty Mall").lat(-15.787249709036422).lon(-47.884654889965816).build();
			p5.addBike(Bike.builder().modelo("modelo1").build());
			pontoRepository.save(p5);

			Ponto p6 = Ponto.builder().nome("Liberty Mall").lat(-15.787249709036422).lon(-47.884654889965816).build();
			p6.addBike(Bike.builder().modelo("modelo1").build());
			pontoRepository.save(p6);

			Agendamento a1 = new Agendamento(null, p1, p2, LocalDate.now(), LocalDate.now(), LocalTime.now(),
					LocalTime.now());
			agendamentoRepository.save(a1);

		}

		if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			System.out.println("-----------------+++++++++++++++++++++++++++++++++++++");
			System.out.println("VERIFICAR ANOTAÇÃO");

		}
	}
}
