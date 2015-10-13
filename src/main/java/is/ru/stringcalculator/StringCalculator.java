package is.ru.stringcalculator;
import java.util.ArrayList;
import java.lang.*;
import java.util.InputMismatchException;

public class StringCalculator {
	public StringCalculator() {

	}

	private static String getNegativeValues(String numbers) {
		String negativeString = "";
		for(int i = 0; i < numbers.length(); i++) {
			if(numbers.charAt(i) == '-') {
				negativeString += numbers.substring(i, i + 2) + ",";
			}
		}
		return negativeString.substring(0, negativeString.length() - 1);
	}

	public static int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;	
		} else {
			if(numbers.contains("-")) {
				throw new InputMismatchException("Negatives not allowed: " + getNegativeValues(numbers));
			}
			String optionalDelimiter = ",|\n";
			if(numbers.charAt(0) == '/') {
				optionalDelimiter +=  "|" + numbers.substring(2,3);
				numbers = numbers.substring(4);
			}
			int sum = 0;
			String[] numberArray = numbers.split(optionalDelimiter);
			for(String number : numberArray) {
				if(toInt(number) <= 1000) {
					sum += toInt(number);
				}
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
