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

import com.bikefy.entity.Ponto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntitiesTests {

	private static final Integer id = 1;
	private static final String nome = "nome";
	private static final Double lat = -10000000d;
	private static final Double lon = 100000.1111111d;
	private static final String endereco = "";
	private static final Integer qtd_bikes = 0;

	@Test
	public void Ponto() {
		Ponto obj1, obj2;
		
		//teste constructor no args
		obj1 = new Ponto();		
		obj1.setId(id);
		obj1.setNome(nome);
		assertNotNull(obj1);
		assertEquals(obj1.getId(), id);
		assertEquals(obj1.getNome(), nome);
		
		//teste constructor all args
		obj1 = new Ponto(id,lat,lon,nome,endereco,qtd_bikes);		
		assertNotNull(obj1);
		assertEquals(obj1.getId(), id);
		assertEquals(obj1.getNome(), nome);
		
		//teste builder
		obj1 = Ponto.builder().id(id).nome(nome).lat(0d).lon(0d).build();		
		assertNotNull(obj1);
		assertEquals(obj1.getId(), id);
		assertEquals(obj1.getNome(), nome);
		assertNotNull(Ponto.builder().id(id).nome(nome).toString());
		
		//teste to string
		assertNotNull(obj1.toString());
		
		//teste hascode e equals					
		obj1 = Ponto.builder().id(id).nome(nome).lat(0d).lon(0d).build();
		obj2 = Ponto.builder().id(id).nome(nome).lat(0d).lon(0d).build();
		assertEquals(obj1.hashCode(), obj2.hashCode());
		assertTrue(obj1.equals(obj2));
		
		obj2 = new Ponto();
		assertNotEquals(obj1.hashCode(), obj2.hashCode());
		assertFalse(obj1.equals(obj2));
		
		obj2 = Ponto.builder().id(id+1).nome("-".concat(nome)).lat(0d).lon(0d).build();
		assertNotEquals(obj1.hashCode(), obj2.hashCode());
		assertFalse(obj1.equals(obj2));		
	}

}
