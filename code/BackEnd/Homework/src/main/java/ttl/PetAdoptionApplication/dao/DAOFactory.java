package ttl.PetAdoptionApplication.dao;

import ttl.PetAdoptionApplication.dao.inmemory.InMemoryAdopterDAO;
import ttl.PetAdoptionApplication.dao.jpa.JPAAdotperDAO;

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
