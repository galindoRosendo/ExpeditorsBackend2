package com.expeditors.adoptionapp.domain;

import com.expeditors.adoptionapp.enums.TypesOfPets;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Pet {
    public Pet(LocalDate date, TypesOfPets.enumTypesOfPets typeOfPet, String name, String breedOfPet){
        this.dateOfAdoption = LocalDate.now();
        this.typeOfPet = typeOfPet;
        this.name = name;
        this.breed = breedOfPet;
    }
    public Pet(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pet;

    public Integer getId_pet() {
        return id_pet;
    }

    public void setId_pet(Integer id_pet) {
        this.id_pet = id_pet;
    }

    private LocalDate dateOfAdoption;
    private TypesOfPets.enumTypesOfPets typeOfPet;
    private String name;
    private String breed;
    @ManyToOne
    @JoinColumn(name = "id_adopter")
    @JsonIgnore
    private Adopter adopter;

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

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
