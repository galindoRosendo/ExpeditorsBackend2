package com.expeditors.adoptionapp.domain;

import com.expeditors.adoptionapp.enums.TypesOfPets;

import java.time.LocalDate;

public class Pet {
    public Pet(LocalDate date, TypesOfPets.enumTypesOfPets typeOfPet, String name, String breedOfPet){
        this.dateOfAdoption = LocalDate.now();
        this.typeOfPet = typeOfPet;
        this.name = name;
        this.breed = breedOfPet;
    }
    public Pet(){

    }
    private LocalDate dateOfAdoption;
    private TypesOfPets.enumTypesOfPets typeOfPet;
    private String name;
    private String breed;

    public LocalDate getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption(LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public TypesOfPets.enumTypesOfPets getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(TypesOfPets.enumTypesOfPets typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
