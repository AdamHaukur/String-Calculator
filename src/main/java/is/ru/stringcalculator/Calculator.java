package is.ru.stringcalculator;

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
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
}