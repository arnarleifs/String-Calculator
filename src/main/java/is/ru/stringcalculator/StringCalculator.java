package is.ru.stringcalculator;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.LinkedList;

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
		// Queue implementation
		int index = 0;
		Queue<Character> queue = new LinkedList<Character>();
		String delimiter = "";
		for(int i = 0; i < numbers.length(); i++) {
			if(numbers.charAt(i) == '\n') {
				index = i;
				break;
			}
			if(numbers.charAt(i) == '[') {
				queue.add(numbers.charAt(i));
			} else if(numbers.charAt(i) == ']') {
				queue.add(numbers.charAt(i));
				int size = queue.size();
				for(int j = 0; j < size; j++) {
					delimiter += Character.toString(queue.remove());
				}
				delimiter += "|";
			} else if(!queue.isEmpty()) {
				queue.add(numbers.charAt(i));
			} else if(queue.isEmpty() && numbers.charAt(i) != '/') {
				delimiter = Character.toString(numbers.charAt(i));
				index = i + 1;
				break;
			}
		}
		String[] delimiterArray = {delimiter.substring(0, delimiter.length()), numbers.substring(index)};
		return delimiterArray;
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
