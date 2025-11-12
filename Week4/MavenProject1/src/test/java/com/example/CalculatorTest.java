package com.example;
import com.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }
    @Test
    void testSubtract() {
		Calculator calc = new Calculator();
		assertEquals(4, calc.subtract(7, 3), "7 - 3 should equal 4");
	}
    @Test
    void testMultiply() {
		Calculator calc = new Calculator();
		assertEquals(15, calc.multiplication(3, 5), "3 * 5 should equal 15");
	}
  
    @Test
    public void testValidateName() {
		
    	String custname ="Jame";
    		Calculator obj = new Calculator();
    		assertTrue(obj.validateName(custname));
    	}
}
