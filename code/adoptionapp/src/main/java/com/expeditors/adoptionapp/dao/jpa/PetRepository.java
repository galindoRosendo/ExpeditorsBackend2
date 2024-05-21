package com.expeditors.adoptionapp.dao.jpa;

import com.expeditors.adoptionapp.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
