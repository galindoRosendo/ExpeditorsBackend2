package ttl.expeditors.backend.app;

import java.time.LocalDate;
import ttl.expeditors.backend.domain.Student;

public class StudentApp {

   public static void main(String[] args) {
      Student s = new Student(10, "Charlene",
            LocalDate.of(2000, 10, 7),
            "a@b.com");
//      s.setId(10);
////      s.setName("Franky");
//      s.setDob(LocalDate.of(2000, 10, 7));
//      s.setEmail("blah@xyz.com");

      System.out.println("s.id: " + s.getId());
      System.out.println("s.name: " + s.getName());
      System.out.println("s.dob: " + s.getDob());
      System.out.println("s.email: " + s.getEmail());

//      Student s2 = new Student();
//      s2.setId(10);
   }
}
