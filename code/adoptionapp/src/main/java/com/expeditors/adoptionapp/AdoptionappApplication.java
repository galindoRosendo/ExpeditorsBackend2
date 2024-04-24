package com.expeditors.adoptionapp;

import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.domain.Pet;
import com.expeditors.adoptionapp.enums.TypesOfPets;
import com.expeditors.adoptionapp.service.AdopterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class AdoptionappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptionappApplication.class, args);
	}
}

@Component
class MyRunner implements CommandLineRunner {
	final AdopterService adopterService;

	public MyRunner(AdopterService adopterService){
		this.adopterService = adopterService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run from comandline runner");
		Pet nina = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Cat, "nina", "Aria");
		Pet noha = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noha", "Rotweiler & Chow chow");
		Adopter adopter1 = new Adopter(1, "Rosendo", "8671413415", noha);
		Adopter adopter2 = new Adopter(1, "Deyanira", "8672455575", nina);
		adopterService.addAdopter(adopter1);
		adopterService.addAdopter(adopter2);

		System.out.println(adopter1.getName());
		System.out.println(adopter2.getName());
	}
}
