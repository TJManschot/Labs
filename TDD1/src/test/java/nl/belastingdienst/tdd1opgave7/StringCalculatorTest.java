package nl.belastingdienst.tdd1opgave7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void testStringCalculatorEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testStringCalculatorSingleInt() {
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(12, stringCalculator.add("12"));
    }

    @Test
    void testStringCalculatorCommaSeparated() {
        assertEquals(3, stringCalculator.add("1, 2"));
    }

    @Test
    void testStringCalculatorCommaOrNewlineSeparated() {
        assertEquals(6, stringCalculator.add("1\n2, 3"));
        assertEquals(10, stringCalculator.add("1, 2, 3\n4"));
        assertEquals(15, stringCalculator.add("1 ,,\n\n 2,, 4 ,3\n5"));
    }

    @Test
    void testStringCalculatorCustomDelimiter() {
        assertEquals(21, stringCalculator.add("//;\n1;2;3;4;5;6"));
    }

    @Test
    void testStringCalculatorNegativeNumber() {
        NumberFormatException e = assertThrows(NumberFormatException.class, () -> stringCalculator.add("42, -20, 100"));
        assertEquals("Negatives not allowed! You passed -20.", e.getMessage());
    }

    @Test
    void testStringCalculatorNegativeNumbers() {
        NumberFormatException e = assertThrows(NumberFormatException.class, () -> stringCalculator.add("42, -20, 100, -5, -10, 2"));
        assertEquals("Negatives not allowed! You passed -20, -5, -10.", e.getMessage());
    }

    @Test
    void testStringCalculatorIgnoreLargerThan1000() {
        assertEquals(2, stringCalculator.add("2, 1001"));
        assertEquals(1002, stringCalculator.add("2, 1000"));
    }
}