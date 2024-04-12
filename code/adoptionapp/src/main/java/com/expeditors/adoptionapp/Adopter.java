package com.expeditors.adoptionapp;

public class Adopter {
    public Adopter(Integer id, String name, String phone, Pet pet){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pet = pet;
    }
    public Adopter(){

    }
    //region Variables
    private Integer id;
    private String name;
    private String phone;
    private Pet pet;
    //endregion
    //region Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id == null) {
            id = 0;
        }
        this.id = id;
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
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    //endregion
}

