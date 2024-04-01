package ttl.expeditors.backend.dao;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import ttl.expeditors.backend.dao.inmemory.InMemoryStudentDAO;
import ttl.expeditors.backend.service.StudentService;

public class DAOFactory {

   private static Map<String, Object> objects = new ConcurrentHashMap<>();

   private static String profile;

   static {
      ResourceBundle bundle = ResourceBundle.getBundle("larku");
      profile = bundle.getString("larku.profile");
   }

   public static StudentDAO studentDAO() {

      return switch (profile) {
         case "dev" -> {
            StudentDAO dao = (StudentDAO) objects.get("studentDAO");
            if (dao == null) {
               dao = new InMemoryStudentDAO();
               objects.put("studentDAO", dao);
            }
            yield dao;
         }
         case "prod" -> (StudentDAO) objects.computeIfAbsent("studentDAO",
               (key) -> new InMemoryStudentDAO());

         default -> throw new RuntimeException("Unknown profile: " + profile);
      };
   }

   public static StudentService studentService() {

      StudentService studentService = (StudentService)
            objects.computeIfAbsent("studentService", (key) -> {
               StudentService service = new StudentService();
               StudentDAO dao = studentDAO();
               service.setStudentDAO(dao);
               return service;
            });
      return studentService;
   }

}
