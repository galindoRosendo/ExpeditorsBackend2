package com.expeditors.adoptionapp.service;

import com.expeditors.adoptionapp.dao.jpa.AdopterRepository;
import com.expeditors.adoptionapp.dao.jpa.PetRepository;
import com.expeditors.adoptionapp.domain.Adopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expeditors.adoptionapp.dao.AdopterDAO;

import java.util.List;
import java.util.Optional;

@Service
public class AdopterService {
    @Autowired
    private AdopterRepository adopterRepository;
    @Autowired
    private PetRepository petRepository;

    public Adopter addAdopter(Adopter adopter) {
        adopter.getPets().forEach(p-> p.setAdopter(adopter));
        adopterRepository.save(adopter);
        return adopter;
    }
    public boolean deleteAdopter(int id) {
        adopterRepository.deleteById(id);
        return true;
    }
    public boolean updateAdopter(Adopter adopter){
        adopterRepository.save(adopter);
        return true;
    }
    public Optional<Adopter> findBy(int id){
        Optional<Adopter> adopter = adopterRepository.findById(id);
        return adopter;
    }
    public List<Adopter> getAllAdopters() {
        return adopterRepository.findAll();
    }
}