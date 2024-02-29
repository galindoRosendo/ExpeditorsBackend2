package ttl.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCasesService {
    @Test
    public void testLoopFor_Success() {
        int a = -500;
        int b = 500;

        int result =  casesService.forLoop(a,b);
        assertEquals(476, result);
    }
    @Test
    public void testLoopFor_Fail() {
        int a = -400;
        int b = 500;

        int result =  casesService.forLoop(a,b);
        assertEquals(476, result);
    }
}
