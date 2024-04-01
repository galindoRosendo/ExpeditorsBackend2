package ttl.expeditors.backend.app;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttl.expeditors.backend.domain.Student;
import ttl.expeditors.backend.jconfig.LarkUConfig;
import ttl.expeditors.backend.service.StudentService;

public class LambdaStreamDemo {

   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

      StudentService ss = context.getBean("studentService", StudentService.class);

      var students = List.of(
            new Student("joe", LocalDate.of(2000, 10, 10), "a@b.com"),
            new Student("Frank", LocalDate.of(1960, 10, 10), "a@b.com"),
            new Student("Rachna", LocalDate.of(1999, 10, 10), "")
      );

      //Add all students to service;
      for(Student student : students) {
         ss.addStudent(student);
      }
      //void accept(T);
      students.forEach(s -> ss.addStudent(s));

      students.forEach(ss::addStudent);

      List<String> namesWithJ = students.stream()
//            .filter(LambdaStreamDemo::complicated)
            .filter(s -> s.getName().startsWith("J"))
            .map(s -> s.getName())
            //.toList();
            .collect(Collectors.toList());

   }

   public static boolean complicated(Student s) {
      return true;
   }

}
