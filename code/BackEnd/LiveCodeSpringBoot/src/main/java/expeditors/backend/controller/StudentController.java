package expeditors.backend.controller;


import expeditors.backend.domain.Student;
import expeditors.backend.service.StudentService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/student")
public class StudentController {

   @Autowired
   private StudentService studentService;

   @GetMapping
   public List<Student> getAllStudents() {
      List<Student> students = studentService.getStudents();
      return students;
   }

   @GetMapping("/{abc}")
   public ResponseEntity<?> getStudent(@PathVariable("abc") int id) {
      Student student = studentService.getStudent(id);
      if (student == null) {
         return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("No student with id: " + id);
      }
      return ResponseEntity.ok(student);
   }

   @PostMapping
   public ResponseEntity<?> addStudent(@RequestBody Student student) {
      Student newStudent = studentService.createStudent(student);

      //http://localhost:8080/student/3

      URI newResource = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(student.getId())
            .toUri();

      //return ResponseEntity.created(newResource).body(newStudent);
      return ResponseEntity.created(newResource).build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
      boolean result = studentService.deleteStudent(id);
      if(!result) {
         return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("No student with id: " + id);
      }

      return ResponseEntity.noContent().build();
   }

   @PutMapping
   public ResponseEntity<?> updateStudent(@RequestBody Student student) {
     boolean result = studentService.updateStudent(student);
      if(!result) {
         return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
               .body("No student with id: " + student.getId());
      }

      return ResponseEntity.noContent().build();
   }
}

//REpresentational State Transfer
