package com.expeditors.adoptionapp.dao;

import com.expeditors.adoptionapp.Adopter;

import java.util.List;

public interface AdopterDAO {
    Adopter insert(Adopter adopter);
    boolean delete(int id);
    boolean update(Adopter adopter);
    Adopter findBy(int id);
    Adopter findBy(String name);
    List<Adopter> findAll();
    List<Adopter> sortByNaturalOrder();
    List<Adopter> sortByName();
}
