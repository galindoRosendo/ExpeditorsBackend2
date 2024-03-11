package ttl.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class studentsServiceTest {
    @Test
    public void testArraySquare_Success() {
        int result = studentsService.CallIntsArray();
        assertEquals(25, result);
    }
}
