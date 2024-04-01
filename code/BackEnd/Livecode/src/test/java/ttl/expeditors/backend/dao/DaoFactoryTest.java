package ttl.expeditors.backend.dao;

import org.junit.jupiter.api.Test;
import ttl.expeditors.backend.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoFactoryTest {

   @Test
   public void testDAOFactoryObjects() {
      StudentDAO dao1 = DAOFactory.studentDAO();

      StudentDAO dao2 = DAOFactory.studentDAO();


      assertTrue(dao1 == dao2);
   }

   @Test
   public void testDAOFactoryStudentServcie() {
      StudentService s1 = DAOFactory.studentService();
      StudentService s2 = DAOFactory.studentService();



      assertTrue(s1 == s2);
      assertTrue(s1.getStudentDAO() == s2.getStudentDAO());
   }
}
