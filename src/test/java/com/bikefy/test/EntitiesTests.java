package com.bikefy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bikefy.entity.Bike;
import com.bikefy.entity.Ponto;

import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntitiesTests {

	private static final Integer id = 1;
	private static final String nome = "nome";
	private static final Double lat = -10000000d;
	private static final Double lon = 100000.1111111d;
	private static final String endereco = "";
	private static final Integer qtd_bikes = 0;
	private static final Integer id_bike = 2;

	@Test
	public void Ponto() {
		Ponto obj1 = new Ponto(id, lat, lon, nome, endereco, qtd_bikes);
		obj1.addBike(Bike.builder().id(id_bike).modelo("").build());
		assertTrue(obj1.getBikes().size()>0);
		assertEquals(obj1.getBikes().get(0).getId(), id_bike);
		assertEquals(obj1.getBikes().get(0).getPonto_atual(), obj1);		
	}
	
		

}
