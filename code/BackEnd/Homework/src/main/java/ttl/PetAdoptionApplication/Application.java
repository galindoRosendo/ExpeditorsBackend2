package ttl.PetAdoptionApplication;

import ttl.PetAdoptionApplication.enums.TypesOfPets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Adopter adopter1 = captureAdopterData();
        Adopter adopter2 = captureAdopterData();
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
                        System.out.println(STR."The adopter dateOfAdoption is \{LocalDate.now()}");
                        adopter.setDateOfAdoption(LocalDate.now());
                        break;
                    case 4:
                        System.out.println("Type adopter typeOfPetAdopted");
                        adopter.setTypeOfPetAdopted(TypesOfPets.enumTypesOfPets.valueOf(reader.nextLine()));
                        break;
                    case 5:
                        System.out.println("Type adopter nameOfPetAdopted");
                        adopter.setNameOfPetAdopted(reader.nextLine());
                        break;
                    case 6:
                        System.out.println("Type adopter breed");
                        adopter.setBreedOfPetAdopted(reader.nextLine());
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
        System.out.println(STR."The id is: \{adopterCaptured.getId()}");
        System.out.println(STR."The name is: \{adopterCaptured.getName()}");
        System.out.println(STR."The phone  is: \{adopterCaptured.getPhone()}");
        System.out.println(STR."The date of adoption is: \{adopterCaptured.getDateOfAdoption()}");
        System.out.println(STR."The type of adopted pet is: \{adopterCaptured.getTypeOfPetAdopted()}");
        System.out.println(STR."The name of adopted pet is: \{adopterCaptured.getNameOfPetAdopted()}");
        System.out.println(STR."The breed of adopted pet is: \{adopterCaptured.getBreedOfPetAdopted()}");
    }
}
