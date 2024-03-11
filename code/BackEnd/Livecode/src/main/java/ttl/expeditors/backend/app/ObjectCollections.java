package ttl.expeditors.backend.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ttl.expeditors.backend.domain.Student;

public class ObjectCollections {

   public static void main(String[] args) {
//      List<Integer> lint = new ArrayList<>();
//      for(int i = 0; i < Integer.MAX_VALUE; i++) {
//         lint.add(i);
//      }
      int [] iarr = new int[10];

      Student [] sarr = new Student[2];

      sarr[0] = new Student(10, "Johe", LocalDate.now(), "a@b.com");
      sarr[1] = new Student(11, "Johe", LocalDate.now(), "a@b.com");

      List<Student> lStudent = new ArrayList<>();

      for(int i = 0; i < sarr.length; i++) {
         lStudent.add(sarr[i]);
      }



   }
}
