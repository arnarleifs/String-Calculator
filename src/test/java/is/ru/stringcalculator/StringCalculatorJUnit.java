package is.ru.stringcalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.InputMismatchException;

// A template class for doing jUnit tests in Java
public class StringCalculatorJUnit {
	private StringCalculator calculator = new StringCalculator();

	@Test 
	public void TestAddWithZeroNumber() {
		// Act
		int returnValue = calculator.Add("");
		// Assert
		assertEquals(0, returnValue);
		System.out.println("TestAddWithZeroNumber passed!");
	}

	@Test
	public void TestAddWithOneNumber() {
		int returnValue = calculator.Add("1");
		assertEquals(1, returnValue);
		System.out.println("TestAddWithOneNumber passed!");
	}

	@Test
	public void TestAddWithTwoNumbers() {
		int returnValue = calculator.Add("1,2");
		assertEquals(3, returnValue);
		System.out.println("TestAddWithTwoNumbers passed!");
	}

	@Test
	public void TestAddWithUnknownNumbers() {
		int returnValue = calculator.Add("1,2,3");
		assertEquals(6, returnValue);
		System.out.println("TestAddWithUnknownNumbers passed!");
	}

	@Test
	public void TestAddWithNullAsDelimiter() {
		int returnValue = calculator.Add("1\n2,3");
		assertEquals(6, returnValue);
		System.out.println("TestAddWithNullAsDelimiter passed!");
	}

	@Test
	public void TestAddWithDifferentDelimiter() {
		int returnValue = calculator.Add("//;\n1;2");
		assertEquals(3, returnValue);
		System.out.println("TestAddWithDifferentDelimiter passed!");
	}

	@Test
	public void TestAddWithPercentAsDelimiter() {
		int returnValue = calculator.Add("//%\n1%2");
		assertEquals(3, returnValue);
		System.out.println("TestAddWithPercentAsDelimiter passed!");
	}

	@Test
	public void TestAddWithNegativeNumbers() {
		String message = "";
		try {
			int returnValue = calculator.Add("-1, -3, 2");	
		} catch(InputMismatchException ex) {
			message = ex.getMessage();
		}
		assertEquals(message, "Negatives not allowed: -1,-3");
		System.out.println("TestAddWithNegativeNumbers passed!");
	}

	@Test
	public void TestAddWithBiggerNumbersThan1000() {
		int returnValue = calculator.Add("1001,2");
		assertEquals(2, returnValue);
		System.out.println("TestAddWithBiggerNumbersThan1000 passed!");
	}

	@Test
	public void TestAddWithDelimiterOfAnyLength() {
		int returnValue = calculator.Add("//[***]\n1***2***3");
		assertEquals(6, returnValue);
		System.out.println("TestAddWithDelimiterOfAnyLength passed!");
	}

	@Test
	public void TestAddWithDelimiterOfLongerLength() {
		int returnValue = calculator.Add("//[;;;;;;;;;;]\n1;;;;;;;;;;2;;;;;;;;;;3");
		assertEquals(6, returnValue);
		System.out.println("TestAddWithDelimiterOfLongerLength passed!");
	}

	@Test
	public void TestAddWithMultipleDelimiter() {
		int returnValue = calculator.Add("//[*][%]\n1*2%3");
		assertEquals(6, returnValue);
		System.out.println("TestAddWithMultipleDelimiter passed!");
	}

	@Test
	public void TestAddWithThreeDifferentDelimiters() {
		int returnValue = calculator.Add("//[*][%][!]\n1*2%3!4");
		assertEquals(10, returnValue);
		System.out.println("TestAddWithThreeDifferentDelimiters passed!");
	}

	@Test
	public void TestWithMultipleDelimitersOfAnyLength() {
		int returnValue = calculator.Add("//[**][%%]\n1**2%%3");
		assertEquals(6, returnValue);
		System.out.println("TestWithMultipleDelimitersOfAnyLength passed!");
	}

	@Test
	public void TestWithMultipleDelimitersOfDifferentLengths() {
		int returnValue = calculator.Add("//[**][%%%%][&]\n1**2%%%%3&4");
		assertEquals(10, returnValue);
		System.out.println("TestWithMultipleDelimitersOfDifferentLengths passed!");
	}
}
