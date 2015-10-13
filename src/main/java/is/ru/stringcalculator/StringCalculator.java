package is.ru.stringcalculator;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private static String[] getDelimiterFromPattern(String numbers) {
		String patternString = "//\\[?([^\\]]*)\\]?\n(.*)";
		String[] groups = {numbers.replaceAll(patternString, "$1"), numbers.replaceAll(patternString, "$2")};
		return groups;
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
				String[] delimiter = getDelimiterFromPattern(numbers);
				if(delimiter[0].length() > 1) {
					delimiter[0] = "[" + delimiter[0] + "]";
				}
				optionalDelimiter += "|" + delimiter[0];
				numbers = delimiter[1];
			}
			int sum = 0;
			String[] numberArray = numbers.split(optionalDelimiter);
			for(String number : numberArray) {
				if(!number.equals("")) {
					if(toInt(number) <= 1000) {
						sum += toInt(number);
					}
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
