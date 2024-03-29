package ttl.expeditors.backend.dao;

import java.util.List;
import ttl.expeditors.backend.domain.Student;

public interface StudentDAO {
   Student insert(Student student);

   boolean delete(int id);

   boolean update(Student student);

   Student findById(int id);

   List<Student> findAll();
}
