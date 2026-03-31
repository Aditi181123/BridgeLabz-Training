package SonarQube.SonarQube;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(4, calculator.subtract(10, 6));
    }

    @Test
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.01);
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testModulus() {
        assertEquals(1, calculator.modulus(5, 2));
    }

    @Test
    void testModulusByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.modulus(10, 0));
    }
}
