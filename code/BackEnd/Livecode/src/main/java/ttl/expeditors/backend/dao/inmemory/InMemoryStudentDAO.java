package ttl.expeditors.backend.dao.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ttl.expeditors.backend.dao.StudentDAO;
import ttl.expeditors.backend.domain.Student;

public class InMemoryStudentDAO implements StudentDAO {

//   private List<Student> studentList = new ArrayList<>();
//   private Set<Student> setOfStudents = new HashSet<>();


   private Map<Integer, Student> students = new HashMap<>();
   private int nextId = 1;


   @Override
   public Student insert(Student student) {
      int id = nextId++;
      student.setId(id);
      student.setName("InMem: " + student.getName());

      students.put(student.getId(), student);
      return student;
   }

   @Override
   public boolean delete(int id) {
      return students.remove(id) != null;
   }

   @Override
   public boolean update(Student student) {
      return students.replace(student.getId(), student) != null;
   }

   @Override
   public Student findById(int id) {
      return students.get(id);
   }

   @Override
   public List<Student> findAll() {
      return new ArrayList<>(students.values());
   }

}

