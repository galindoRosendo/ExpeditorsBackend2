package PetAdoptionApplication;

import org.junit.jupiter.api.Test;
import ttl.PetAdoptionApplication.Adopter;
import ttl.PetAdoptionApplication.Pet;
import ttl.PetAdoptionApplication.enums.TypesOfPets;
import ttl.PetAdoptionApplication.serivice.AdopterService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdopterServiceTests {
    AdopterService service = new AdopterService();
    @Test
    public void testAddAdopter(){

        Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
        Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", noah);
        service.addAdopter(rosendo);

        assertEquals("rosendo", rosendo.getName());
    }
    @Test
    public void testDeleteAdopter(){
        assertEquals(true, service.deleteAdopter(1));
    }
    @Test
    public void testUpdateAdopter(){
        Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
        Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", noah);
        assertEquals(true, service.updateAdopter(rosendo));
    }
    @Test
    public void testFindByIdAdopter(){
        assertEquals(1, service.findBy(1).getId());
    }
    @Test
    public void testFindByNameAdopter(){
        assertEquals("rosendo", service.findBy(1).getName());
    }

}
