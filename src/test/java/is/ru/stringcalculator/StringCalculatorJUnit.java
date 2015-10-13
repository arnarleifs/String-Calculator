package is.ru.stringcalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
