package com.expeditors.adoptionapp.dao;

import com.expeditors.adoptionapp.dao.inmemory.InMemoryAdopterDAO;
import com.expeditors.adoptionapp.dao.jpa.JPAAdotperDAO;

import java.util.ResourceBundle;

public class DAOFactory {

    public static AdopterDAO adopterDAO() {
        ResourceBundle bundle = ResourceBundle.getBundle("larku");
        String profile = bundle.getString("larku:profile");

        return switch(profile) {
            case "dev" -> new InMemoryAdopterDAO();
            case "prod" -> new JPAAdotperDAO();
            default -> throw new RuntimeException("Unknown profile: " + profile);
        };
    }
}
