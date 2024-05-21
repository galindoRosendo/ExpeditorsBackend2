package com.expeditors.adoptionapp.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Adopter {
    public Adopter(Integer id_adopter, String name, String phone, List<Pet> pets){
        this.id_adopter = id_adopter;
        this.name = name;
        this.phone = phone;
        this.pets = pets;
    }
    public Adopter(){

    }
    //region Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_adopter;
    private String name;
    private String phone;
    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL)
    private List<Pet> pets;
    //endregion
    //region Getters & Setters
    public Integer getId() {
        return id_adopter;
    }

    public void setId(Integer id_adopter) {
        if(id_adopter == null) {
            id_adopter = 0;
        }
        this.id_adopter = id_adopter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            name = "";
        }
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone == null) {
            phone = "";
        }

        this.phone = phone;
    }
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    //endregion
}

