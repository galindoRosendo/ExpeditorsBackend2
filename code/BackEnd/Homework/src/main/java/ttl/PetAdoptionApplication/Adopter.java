package ttl.PetAdoptionApplication;

import ttl.PetAdoptionApplication.enums.TypesOfPets;

import java.time.LocalDate;
import java.time.LocalTime;

public class Adopter {
    //region Variables
    private Integer id;
    private String name;
    private String phone;
    private LocalDate dateOfAdoption;
    private TypesOfPets.enumTypesOfPets typeOfPetAdopted;
    private String nameOfPetAdopted;
    private String breedOfPetAdopted;
    //endregion
    //region Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption(LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public TypesOfPets.enumTypesOfPets getTypeOfPetAdopted() {
        return typeOfPetAdopted;
    }

    public void setTypeOfPetAdopted(TypesOfPets.enumTypesOfPets typeOfPetAdopted) {
        this.typeOfPetAdopted = typeOfPetAdopted;
    }

    public String getNameOfPetAdopted() {
        return nameOfPetAdopted;
    }

    public void setNameOfPetAdopted(String nameOfPetAdopted) {
        this.nameOfPetAdopted = nameOfPetAdopted;
    }

    public String getBreedOfPetAdopted() {
        return breedOfPetAdopted;
    }

    public void setBreedOfPetAdopted(String breedOfPetAdopted) {
        this.breedOfPetAdopted = breedOfPetAdopted;
    }
    //endregion
}

