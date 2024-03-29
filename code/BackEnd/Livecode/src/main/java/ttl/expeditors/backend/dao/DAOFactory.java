package ttl.expeditors.backend.dao;

import java.util.ResourceBundle;
import ttl.expeditors.backend.dao.inmemory.InMemoryStudentDAO;
import ttl.expeditors.backend.dao.jpa.JPAStudentDAO;

public class DAOFactory {

   public static StudentDAO studentDAO() {
      ResourceBundle bundle = ResourceBundle.getBundle("larku");
      String profile = bundle.getString("larku.profile");

      return switch(profile) {
         case "dev" -> new InMemoryStudentDAO();
         case "prod" -> new JPAStudentDAO();
         default -> throw new RuntimeException("Unknown profile: " + profile);
      };
   }
}
