package com.expeditors.adoptionapp.controller;

import com.expeditors.adoptionapp.domain.Pet;
import com.expeditors.adoptionapp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllAdopters() {
        List<Pet> pets = petService.getAllPets();
        return pets;
    }

    @GetMapping("/{abc}")
    public ResponseEntity<?> getPet(@PathVariable("abc") int id) {
        Optional<Pet> pet = petService.findBy(id);
        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pet with id: " + id);
        }
        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<?> addPet(@RequestBody Pet pet) {
        Pet newAdopter = petService.addPet(pet);

        //http://localhost:8080/pet/3

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(pet.getName())
                .toUri();

        //return ResponseEntity.created(newResource).body(newAdopter);
        return ResponseEntity.created(newResource).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") int id) {
        boolean result = petService.deletePet(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pet with id: " + id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Pet pet) {
        boolean result = petService.updatePet(pet);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No pet with id: " + pet.getId_pet());
        }

        return ResponseEntity.noContent().build();
    }
}
