package ttl.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class studentsServiceTest {
    @Test
    public void testArraySquare_Success() {
        int result = StudentsService.CallIntsArray();
        assertEquals(25, result);
    }

    @Test
    public void testArrayItem2(){
        Integer[] result =  StudentsService.createArray(5,10);

        Integer bigestInt = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > bigestInt) {
                bigestInt = result[i];
            }
        }
        assertTrue(bigestInt<10);
        assertEquals(5, result.length);
    }
}
