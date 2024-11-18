package org.delta;
import org.delta.interesting.InterestingCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    public void testAdd(){
        assertEquals(42, Integer.sum(19,23));
    }

    @Test
    public void testDivide(){
        assertThrows(ArithmeticException.class, () -> {
            Integer.divideUnsigned(42,0);
        });
    }
}
