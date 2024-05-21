package com.expeditors.adoptionapp;

import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.domain.Pet;
import com.expeditors.adoptionapp.enums.TypesOfPets;
import com.expeditors.adoptionapp.service.AdopterService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AdoptionappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	AdopterService service;
	@Test
	public void addAdopter(){
		Adopter rosendo = new Adopter(null, "Alberto", "8671413415", null);
		service.addAdopter(rosendo);
		assertEquals("Alberto", rosendo.getName());
	}
	@Test
	public void addAdopterWithPet(){
		Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
		Adopter rosendo = new Adopter(null, "Rosendo", "8671413415", List.of(noah));
		service.addAdopter(rosendo);
		assertEquals("Rosendo", rosendo.getName());
	}
	@Test
	public void deleteAdopter(){
        assertTrue(service.deleteAdopter(1));
	}
	@Test
	public void updateAdopter(){
		Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
		Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", null);
        assertTrue(service.updateAdopter(rosendo));
	}
	@Test
	public void findByIdAdopter(){
		assertTrue(service.findBy(1).isPresent());
	}
	@Test
	public void findByNameAdopter(){
		assertTrue( service.findBy(1).isPresent());
	}
	@Test
	public void getAllAdopters(){
        assertFalse(service.getAllAdopters().isEmpty());
	}

}
