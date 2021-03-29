package nl.belastingdienst.tdd1opgave7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void testStringCalculator() {
        assertEquals(0, stringCalculator.add(""));
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(3, stringCalculator.add("1, 2"));
        assertEquals(6, stringCalculator.add("1\n2, 3"));
        assertEquals(10, stringCalculator.add("1, 2, 3\n4"));
        assertEquals(15, stringCalculator.add("1 ,,\n\n 2,, 4 ,3\n5"));
        assertEquals(21, stringCalculator.add("//;\n1;2;3;4;5;6"));
    }
}