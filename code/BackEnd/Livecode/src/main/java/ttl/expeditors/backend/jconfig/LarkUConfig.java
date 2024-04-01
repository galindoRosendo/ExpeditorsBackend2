package ttl.expeditors.backend.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ttl.expeditors.backend.dao.StudentDAO;
import ttl.expeditors.backend.dao.inmemory.InMemoryStudentDAO;
import ttl.expeditors.backend.service.StudentService;

@Configuration
//@ComponentScan({"ttl.expeditors.backend.service", "ttl.expeditors.backend.dao"})
@ComponentScan({"ttl.expeditors.backend"})
public class LarkUConfig {
   /*
    <bean id="inMemoryStudentDAO" class="ttl.expeditors.backend.dao.inmemory.InMemoryStudentDAO"/>
   */

   @Bean
   public StudentDAO studentDAO() {
      StudentDAO dao = new InMemoryStudentDAO();
      return dao;
   }

   /*
    <bean id="studentService" class="ttl.expeditors.backend.service.StudentService" >
        <property name="studentDAO" ref="inMemoryStudentDAO"/>
    </bean>
    */
   @Bean
   public StudentService studentService() {
      StudentService service = new StudentService();

      StudentDAO dao = studentDAO();

      service.setStudentDAO(dao);
      return service;
   }
}
