package com.expeditors.adoptionapp.service;

import com.expeditors.adoptionapp.dao.jpa.AdopterRepository;
import com.expeditors.adoptionapp.dao.jpa.PetRepository;
import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private AdopterRepository adopterRepository;
    @Autowired
    private PetRepository petRepository;

    public Pet addPet(Pet pet) {
        pet.setAdopter(pet.getAdopter());
        petRepository.save(pet);
        return pet;
    }
    public boolean deletePet(int id) {
        petRepository.deleteById(id);
        return true;
    }
    public boolean updatePet(Pet pet){
        petRepository.save(pet);
        return true;
    }
    public Optional<Pet> findBy(int id){
        Optional<Pet> pet = petRepository.findById(id);
        return pet;
    }
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
