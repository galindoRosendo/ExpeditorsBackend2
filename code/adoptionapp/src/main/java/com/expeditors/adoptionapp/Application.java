package com.expeditors.adoptionapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.expeditors.adoptionapp.enums.TypesOfPets;
import com.expeditors.adoptionapp.jconfig.AdopterAppConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(AdopterAppConfig.class);
        context.refresh();
        AdopterService adopterService = context.getBean("adopterService", AdopterService.class);

        Pet nina = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Cat, "nina", "Aria");
        Pet noha = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noha", "Rotweiler & Chow chow");
        Adopter adopter1 = new Adopter(1, "Rosendo", "8671413415", noha);
        Adopter adopter2 = new Adopter(1, "Deyanira", "8672455575", nina);

        List<Adopter> adopters = List.of(adopter1, adopter2);

        PrintAdopterData(adopter1);
        PrintAdopterData(adopter2);

    }
    public static Adopter captureAdopterData() {
        Adopter adopter = new Adopter();

        try {
            Scanner reader = new Scanner(System.in);
            for(int i = 0; i < 7; i++) {
                switch (i) {
                    case 0:
                        System.out.println("Type adopter Identification Number");
                        adopter.setId(Integer.parseInt(reader.nextLine()));
                        break;
                    case 1:
                        System.out.println("Type adopter name");
                        adopter.setName(reader.nextLine());
                        break;
                    case 2:
                        System.out.println("Type adopter phone");
                        adopter.setPhone(reader.nextLine());
                        break;
                    case 3:
                        System.out.println("The pet's dateOfAdoption is" + LocalDate.now());

                        break;
                    case 4:
                        System.out.println("Type adopter typeOfPetAdopted");

                        break;
                    case 5:
                        System.out.println("Type adopter nameOfPetAdopted");

                        break;
                    case 6:
                        System.out.println("Type adopter breed");

                        break;
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        };

        return adopter;
    }
    public static void PrintAdopterData(Adopter adopterCaptured) {
        System.out.println("The id is: " + adopterCaptured.getId());
        System.out.println("The name is: " + adopterCaptured.getName());
        System.out.println("The phone  is: " + adopterCaptured.getPhone());
        System.out.println("The date of adoption is: " + adopterCaptured.getPet().getDateOfAdoption());
        System.out.println("The type of adopted pet is: " + adopterCaptured.getPet().getTypeOfPet());
        System.out.println("The name of adopted pet is: " + adopterCaptured.getPet().getName());
        System.out.println("The breed of adopted pet is: " + adopterCaptured.getPet().getBreed());
    }
}
