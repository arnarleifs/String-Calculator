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
			int sum = 0;
			String[] numberArray = numbers.split(",|\n");
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
