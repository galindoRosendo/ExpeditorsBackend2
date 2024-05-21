package com.expeditors.adoptionapp.dao.jpa;

import com.expeditors.adoptionapp.domain.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
}
