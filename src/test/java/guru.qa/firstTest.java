package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class firstTest {
    @Test
    void firstTest(){
        int a = 4;
        int b = 9;
        Assertions.assertTrue(a < b);


    }

    void firstTest2(){
        int a = 4;
        int b = 9;
        Assertions.assertFalse(a > b);
    }
}
