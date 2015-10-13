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
}
