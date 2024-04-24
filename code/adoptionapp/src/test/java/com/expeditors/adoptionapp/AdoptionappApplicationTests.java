package com.expeditors.adoptionapp;

import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.domain.Pet;
import com.expeditors.adoptionapp.enums.TypesOfPets;
import com.expeditors.adoptionapp.service.AdopterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdoptionappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	AdopterService service;
	@Test
	public void testAddAdopter(){

		Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
		Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", noah);
		service.addAdopter(rosendo);

		assertEquals("Rosendo", rosendo.getName());
	}
	@Test
	public void testDeleteAdopter(){
		assertEquals(true, service.deleteAdopter(1));
	}
	@Test
	public void testUpdateAdopter(){
		Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
		Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", noah);
		assertEquals(true, service.updateAdopter(rosendo));
	}
	@Test
	public void testFindByIdAdopter(){
		assertEquals(1, service.findBy(1).getId());
	}
	@Test
	public void testFindByNameAdopter(){
		assertEquals("rosendo", service.findBy(1).getName());
	}

}
