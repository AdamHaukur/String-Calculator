package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLineMultipleNumbers(){
    	assertEquals(9, Calculator.add("2,3\n4"));
    }

    @Test
    public void testDelimiterNumbers(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testBiggerThen1000(){
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
	public void testNegativeNumbers() {
		try 
		{
			Calculator.add("-1,2");
		}

		catch (RuntimeException exeption)
		{
			assertEquals("Negatives not allowed: -1", exeption.getMessage());
		}
	}	

    @Test
	public void testNegativeMultipleNumbers() {
		try 
		{
			Calculator.add("2,-4,3,-5");
		}

		catch (RuntimeException exeption)
		{
			assertEquals("Negatives not allowed: -4,-5", exeption.getMessage());
		}
	}	
  
}