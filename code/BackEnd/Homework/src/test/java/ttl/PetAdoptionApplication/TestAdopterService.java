package ttl.PetAdoptionApplication;

import org.junit.jupiter.api.Test;
import ttl.PetAdoptionApplication.enums.TypesOfPets;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdopterService {
    @Test
    public void testCreateAdopterAndPet(){
        Pet noah = new Pet(LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler");
        Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", noah);
        assertEquals("noah", rosendo.getPet().getName());
    }

    @Test
    public void testCreatePetWithinAdopter(){
        Adopter rosendo = new Adopter(1, "Rosendo", "8671413415", new Pet(
                LocalDate.now(), TypesOfPets.enumTypesOfPets.Dog, "noah", "rotweiler"
        ));
        assertEquals("noah", rosendo.getPet().getName());
    }
}
