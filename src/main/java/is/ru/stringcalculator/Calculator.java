package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	public static String del = ",|\n|;";

	public static int add(String text){
		String[] numbers = text.split(del);

		if(text.equals("")){
			return 0;
		}
		else if(text.length() == 1){
			return toInt(text);
		}
		else if(text.startsWith("//")){
			return sum(delimiter(text));
		}
		else{
			return sum(numbers);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] delimiter(String numbers) {
		numbers = numbers.substring(4, numbers.length());
		return numbers.split(del);
	}
	
    private static int sum(String[] numbers){
 	    int total = 0;
 	    ArrayList<Integer> negative = new ArrayList<Integer>();
        for(String number : numbers){
        	if(toInt(number) < 0){
        		negative.add(toInt(number));
        	}
        	else if(toInt(number) < 1000){
        		total += toInt(number);
        	}
		}
		if (negative.size() < 0) {
       		 throw new RuntimeException("Negatives not allowed: " + negative.toString());
   		 }
    	return total;
    }
}