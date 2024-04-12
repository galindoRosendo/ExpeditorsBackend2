package com.expeditors.adoptionapp.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ttl.PetAdoptionApplication.dao.AdopterDAO;
import ttl.PetAdoptionApplication.dao.inmemory.InMemoryAdopterDAO;
import ttl.PetAdoptionApplication.serivice.AdopterService;

@Configuration
//@ComponentScan({"ttl.expeditors.backend.service", "ttl.expeditors.backend.dao"})
@ComponentScan({"ttl.PetAdoptionApplication"})
public class AdopterAppConfig {
    @Bean
    public AdopterDAO adopterDAO(){
        AdopterDAO dao = new InMemoryAdopterDAO();
        return dao;
    }

    @Bean
    public AdopterService adopterService(){
        AdopterService service = new AdopterService();

        AdopterDAO dao = adopterDAO();
        service.setAdopterDAO(dao);
        return service;
    }
}
