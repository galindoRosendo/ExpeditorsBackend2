package ttl.expeditors.backend.app;

import java.time.LocalDate;
import java.util.List;
import ttl.expeditors.backend.domain.Student;
import ttl.expeditors.backend.service.StudentService;

public class StudentPatternsApp {

   public static void main(String[] args) {
      StudentPatternsApp app = new StudentPatternsApp();
      app.go();
   }

   public void go() {
     postAStudent();
     getAllStudents();
   }

   StudentService ss = new StudentService();
   public void postAStudent() {
      Student student = new Student("Bulbul", LocalDate.of(1934, 10, 10), "a@b.com");

      Student newStudent = ss.addStudent(student);

      List<Student> students = ss.getAllStudents();
      System.out.println("student: " + students.size());
      students.forEach(System.out::println);
   }

   public void getAllStudents() {
//      StudentService ss = new StudentService();


      List<Student> students = ss.getAllStudents();
      System.out.println("student: " + students.size());
      students.forEach(System.out::println);
   }
}
