package com.expeditors.adoptionapp.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.expeditors.adoptionapp.dao.AdopterDAO;
import com.expeditors.adoptionapp.dao.inmemory.InMemoryAdopterDAO;
import com.expeditors.adoptionapp.service.AdopterService;

@Configuration
//@ComponentScan({"ttl.expeditors.backend.service", "ttl.expeditors.backend.dao"})
@ComponentScan({"com.expeditors.adoptionapp"})
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
