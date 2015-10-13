package is.ru.stringcalculator;
import java.util.ArrayList;
import java.lang.*;

public class StringCalculator {
	public StringCalculator() {

	}
	public static int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;	
		} else {
			String[] numberArray = numbers.split(",");
			if(numberArray.length > 1) {
				return toInt(numberArray[0]) + toInt(numberArray[1]);
			} else {
				return toInt(numberArray[0]);
			}
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}

	public static void main(String[] args) {

	}
}
