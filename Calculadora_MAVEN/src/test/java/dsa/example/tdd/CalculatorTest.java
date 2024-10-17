package dsa.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {

    /**
     * Rigorous Test :-)
     */
    Calculator calculator = new Calculator();
    @Test
    public void testAddition(){
        assertEquals(5, calculator.add(2,3),"Testing addition of 2+3");
    }

    @Test
    public void testSubstraction(){
        assertEquals(1, calculator.substract(3,2),"Testing substraction of 3-2");
    }

    @Test
    public void testMultiplication(){
        assertEquals(6, calculator.multiply(2,3),"Testing multiplication of 2*3");
    }

    @Test
    public void testDivision(){
        assertEquals(2, calculator.divide(6,3),"Testing divition of 6/3");
    }
    @Test
    public void testExceptionDivision(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5,0), "Expected divide by zero to throw");

    }

}
