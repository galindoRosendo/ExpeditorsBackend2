package com.expeditors.adoptionapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expeditors.adoptionapp.dao.AdopterDAO;

import java.util.List;

@Service
public class AdopterService {
    @Autowired
    private AdopterDAO adopterDAO;

    public Adopter addAdopter(Adopter adopter) {

        Adopter insertedAdopter = adopterDAO.insert(adopter);

        return insertedAdopter;
    }

    public boolean deleteAdopter(int id) {
        return adopterDAO.delete(id);
    }

    public boolean updateAdopter(Adopter adopter){
        return adopterDAO.update(adopter);
    }

    public Adopter findBy(int id){
        return adopterDAO.findBy(id);
    }

    public Adopter findBy(String name){
        return adopterDAO.findBy(name);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAll();
    }

    public List<Adopter> sortByNaturalOrder() {
        return adopterDAO.sortByNaturalOrder();
    }

    public AdopterDAO getStudentDAO() {
        return adopterDAO;
    }

    public void setAdopterDAO(AdopterDAO adopterDAO){
        this.adopterDAO = adopterDAO;
    }
}
