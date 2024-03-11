package ttl.expeditors.backend.app;

import java.time.LocalDate;
import ttl.expeditors.backend.domain.Student;

public class StudentApp {

   public static void main(String[] args) {
      Student s = new Student(10, "Charlene",
            LocalDate.of(2000, 10, 7),
            "a@b.com");

      int i1i = s.getId();

      Student s2 = new Student(12, "Charlene",
            LocalDate.of(2000, 10, 7),
            "a@b.com", Student.Status.PART_TIME);

      int i2 = s2.getId();

      Student s3 = new Student(10, "Charlene",
            LocalDate.of(2000, 10, 7),
            "a@b.com", "PART_TIME");

      System.out.println(s2.getStatus());

//      System.out.println("s.id: " + s.getId());
//      System.out.println("s.name: " + s.getName());
//      System.out.println("s.dob: " + s.getDob());
//      System.out.println("s.email: " + s.getEmail());
//      System.out.println("s.status: " + s.getStatus());

//      Student s2 = new Student();
//      s2.setId(10);
   }
}
