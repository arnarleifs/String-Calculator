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
			String optionalDelimiter = ",|\n";
			if(numbers.charAt(0) == '/') {
				optionalDelimiter +=  "|" + numbers.substring(2,3);
				numbers = numbers.substring(4);
			}
			int sum = 0;
			String[] numberArray = numbers.split(optionalDelimiter);
			for(int i = 0; i < numberArray.length; i++) {
				sum += toInt(numberArray[i]);
			}
			return sum;
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}

	public static void main(String[] args) {

	}
}
