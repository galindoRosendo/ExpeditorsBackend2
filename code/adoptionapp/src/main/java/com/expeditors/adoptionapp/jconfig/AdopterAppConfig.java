package com.expeditors.adoptionapp.jconfig;

import com.expeditors.adoptionapp.dao.jpa.JPAAdotperDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.expeditors.adoptionapp.dao.AdopterDAO;
import com.expeditors.adoptionapp.dao.inmemory.InMemoryAdopterDAO;
import com.expeditors.adoptionapp.service.AdopterService;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//@ComponentScan({"ttl.expeditors.backend.service", "ttl.expeditors.backend.dao"})
@ComponentScan({"com.expeditors.adoptionapp"})
public class AdopterAppConfig {
    @Bean
    @Profile("dev")
    public AdopterDAO adopterDAO(){
        AdopterDAO dao = new JPAAdotperDAO();
        return dao;
    }

//    @Bean
//    public DataSource dataSource() {
//        String url = "jdbc:postgresql://localhost:5433/larku";
//        String user = "larku";
//        String pw = System.getenv("DB_PASSWORD");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, pw);
//        return dataSource;
//    }

}
