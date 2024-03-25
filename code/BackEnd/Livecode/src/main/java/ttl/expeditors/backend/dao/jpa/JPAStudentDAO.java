package ttl.expeditors.backend.dao.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ttl.expeditors.backend.dao.StudentDAO;
import ttl.expeditors.backend.domain.Student;

public class JPAStudentDAO implements StudentDAO {

//   private List<Student> studentList = new ArrayList<>();
//   private Set<Student> setOfStudents = new HashSet<>();


   private Map<Integer, Student> students = new HashMap<>();
   private int nextId = 1;


   public Student insert(Student student) {
      int id = nextId++;
      student.setId(id);
      student.setName("JPA: " + student.getName());

      students.put(student.getId(), student);
      return student;
   }

   public boolean delete(int id) {
      return students.remove(id) != null;
   }

   public boolean update(Student student) {
      return students.replace(student.getId(), student) != null;
   }

   public Student findById(int id) {
      return students.get(id);
   }

   public List<Student> findAll() {
      return new ArrayList<>(students.values());
   }

}

