package com.expeditors.adoptionapp.controller;

import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adopter")
public class AdopterController {
    @Autowired
    private AdopterService adopterService;

    @GetMapping
    public List<Adopter> getAllAdopters() {
        List<Adopter> adopters = adopterService.getAllAdopters();
        return adopters;
    }

    @GetMapping("/{abc}")
    public ResponseEntity<?> getAdopter(@PathVariable("abc") int id) {
        Optional<Adopter> adopter = adopterService.findBy(id);
        if (adopter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with id: " + id);
        }
        return ResponseEntity.ok(adopter);
    }

    @PostMapping
    public ResponseEntity<?> addAdopter(@RequestBody Adopter adopter) {
        Adopter newAdopter = adopterService.addAdopter(adopter);

        //http://localhost:8080/adopter/3

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(adopter.getId())
                .toUri();

        //return ResponseEntity.created(newResource).body(newAdopter);
        return ResponseEntity.created(newResource).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdopter(@PathVariable("id") int id) {
        boolean result = adopterService.deleteAdopter(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with id: " + id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Adopter adopter) {
        boolean result = adopterService.updateAdopter(adopter);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No adopter with id: " + adopter.getId());
        }

        return ResponseEntity.noContent().build();
    }
}
