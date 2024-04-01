package ttl.expeditors.backend.service;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ttl.expeditors.backend.domain.Student;
import ttl.expeditors.backend.jconfig.LarkUConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LarkUConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentServiceTest {

   @Autowired
   private StudentService studentService;

   @Autowired
   private ApplicationContext context;

   @BeforeEach
   public void beforeEach() {
//      ss = new StudentService();
   }
   @Test
   public void testInsertStudent() {
      Student student = new Student("Bulbul", LocalDate.of(1934, 10, 10), "a@b.com");


      Student student2 = new Student("Other Guy", LocalDate.of(1934, 10, 10), "a@b.com");

      Student insertedStudent = studentService.addStudent(student);
      Student insertedStudent2 = studentService.addStudent(student2);

      System.out.println("s: " + insertedStudent.toString());
      assertNotNull(insertedStudent);
      assertEquals(1, insertedStudent.getId());
      assertEquals(2, insertedStudent2.getId());
   }

   @Test
   public void testDeleteExistingStudent() {
      Student student = new Student("Bulbul", LocalDate.of(1934, 10, 10), "a@b.com");

      Student insertedStudent = studentService.addStudent(student);
      assertNotNull(insertedStudent);

      boolean result = studentService.deleteStudent(insertedStudent.getId());
      assertTrue(result);
   }

   @Test
   public void testDeleteNonExistingStudent() {
      boolean result = studentService.deleteStudent(9999);
      assertFalse(result);
   }
}
