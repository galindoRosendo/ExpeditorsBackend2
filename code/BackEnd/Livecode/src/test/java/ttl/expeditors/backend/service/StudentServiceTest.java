package ttl.expeditors.backend.service;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ttl.expeditors.backend.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentServiceTest {

   @Test
   public void testInsertStudent() {
      Student student = new Student("Bulbul", LocalDate.of(1934, 10, 10), "a@b.com");

      StudentService ss = new StudentService();

      Student student2 = new Student("Other Guy", LocalDate.of(1934, 10, 10), "a@b.com");

      Student insertedStudent = ss.addStudent(student);
      Student insertedStudent2 = ss.addStudent(student2);

      System.out.println("s: " + insertedStudent.toString());
      assertNotNull(insertedStudent);
      assertEquals(1, insertedStudent.getId());
      assertEquals(2, insertedStudent2.getId());
   }

   @Test
   public void testDeleteExistingStudent() {
      Student student = new Student("Bulbul", LocalDate.of(1934, 10, 10), "a@b.com");

      StudentService ss = new StudentService();

      Student insertedStudent = ss.addStudent(student);
      assertNotNull(insertedStudent);

      boolean result = ss.deleteStudent(insertedStudent.getId());
      assertTrue(result);
   }

   @Test
   public void testDeleteNonExistingStudent() {
      StudentService ss = new StudentService();

      boolean result = ss.deleteStudent(9999);
      assertFalse(result);
   }
}
