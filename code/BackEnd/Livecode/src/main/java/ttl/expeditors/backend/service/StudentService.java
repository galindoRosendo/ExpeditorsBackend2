package ttl.expeditors.backend.service;

import java.util.List;
import ttl.expeditors.backend.dao.DAOFactory;
import ttl.expeditors.backend.dao.StudentDAO;
import ttl.expeditors.backend.domain.Student;

/*
1. StudentService should allow users to perform basic create, update, delete operations on Students to a store.
2. StudentService should allow users to retrieve a Student by ID
3. StudentService should allow users to retrieve all Students.

 */
public class StudentService {

   private StudentDAO studentDAO;
//   private InMemoryStudentDAO studentDAO;
//   private JPAStudentDAO studentDAO;

   public StudentService() {
//      studentDAO = new InMemoryStudentDAO();
//      studentDAO = new JPAStudentDAO();
      studentDAO = DAOFactory.studentDAO();
   }

   public Student addStudent(Student student) {
      //Validations

      Student insertedStudent = studentDAO.insert(student);

      return insertedStudent;
   }

   public boolean deleteStudent(int id) {
      return studentDAO.delete(id);
   }

   public boolean updateStudent(Student student) {
      return studentDAO.update(student);
   }

   public Student findById(int id) {
      return studentDAO.findById(id);
   }

   public List<Student> getAllStudents() {
      return studentDAO.findAll();
   }

//   public StudentDAO getStudentDAO() {
//public JPAStudentDAO getStudentDAO() {
   public StudentDAO getStudentDAO() {
      return studentDAO;
   }

//   public void setStudentDAO(StudentDAO studentDAO) {
//public void setStudentDAO(JPAStudentDAO studentDAO) {
   public void setStudentDAO(StudentDAO studentDAO) {
      this.studentDAO = studentDAO;
   }
}
