package ttl.larku.dao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ttl.larku.domain.ClassWithCodeDTO;
import ttl.larku.domain.ScheduledClass;

@Repository
public interface ClassRepo extends JpaRepository<ScheduledClass, Integer> {

   @Query("select sc from ScheduledClass sc join fetch sc.course")
   List<ScheduledClass> findAllWithCourse();

   @Query("select sc.startDate, sc.endDate, c.code from ScheduledClass sc join sc.course c")
   List<Object[]> findWithObjArray();

   @Query("select new ttl.larku.domain.ClassWithCodeDTO(sc.startDate, sc.endDate, c.code) from ScheduledClass sc join sc.course c")
   List<ClassWithCodeDTO> findWithDatesAndCode();

   @Query("select new ttl.larku.domain.ClassWithCodeDTO(sc.startDate, sc.endDate, c.code) from ScheduledClass " +
        "sc join sc.course c where c.code = :code")
   List<ClassWithCodeDTO> findWithDatesAndCode(String code);
}
