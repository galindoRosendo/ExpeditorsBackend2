package ttl.expeditors.backend.app;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttl.expeditors.backend.domain.Course;
import ttl.expeditors.backend.domain.Student;
import ttl.expeditors.backend.jconfig.LarkUConfig;
import ttl.expeditors.backend.service.CourseService;
import ttl.expeditors.backend.service.StudentService;

public class SpringDemo {

   public static void main(String[] args) {
      SpringDemo sd = new SpringDemo();
      //sd.goStudent();
      sd.goCourse();
   }

   public void goStudent() {
      //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

      StudentService ss = context.getBean("studentService", StudentService.class);

      List<Student> students = ss.getAllStudents();
      System.out.println("students: " + students.size());
      System.out.println(students);
   }

   public void goCourse() {
      //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

      CourseService ss = context.getBean("courseService", CourseService.class);

      List<Course> courses = ss.getAllCourses();
      System.out.println("students: " + courses.size());
      System.out.println(courses);
   }
}
