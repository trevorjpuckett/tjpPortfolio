
import java.util.*;

public class ClassCalculator {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		double product = doMult(doAddition());
		System.out.println("Product:  " + product);
		double somethingReturned = doSomething(getDouble(),getInteger(),getName());
		System.out.println(somethingReturned);

	}
	static double doSomething(double itsADouble, int itsAInteger, String itsAString){
		System.out.printf("Hello, %s%n", itsAString);
		double sum = itsADouble + itsAInteger;
		return	sum * 6;
	}

	static String getName(){
		String name = "";
		System.out.print("Enter your name:  ");
		name = scanner.next();
		return name;
	}

	static double doMult(int number){
		double product = number;
		int n = 0;
		System.out.print("Enter the amount of numbers you would like to multiply but the previous sum: ");
		n = getInteger();
		for(int x = 0; x < n; x++){
			double mult = getDouble();
			product = product * mult;
		}
	return product;
	}
	static int doAddition(){
		int sum = 0;
		int n = 0;
		System.out.print("Enter the amount of numbers you would like to add: ");
		n = getInteger();
		for(int x = 0; x < n; x++){
			int number = getInteger();
			sum += number;
		}
	return sum;
	}//close doAddition

	static int getInteger(){
		String sResult = "";
		int result = 0;
		boolean isInteger = false;
		System.out.print("Enter a number:  ");
		do {
			sResult = scanner.next();
			try {
				result = Integer.parseInt(sResult);
				isInteger = true;
			}catch(NumberFormatException nfe){
				System.out.println("Oooops, that doesnt seem to be a number...");
				System.out.println("Try again!");
			}
		}while(!isInteger);
	return result;
	}//close getInteger

	static double getDouble(){
		String sResult = "";
		double result = 0;
		boolean isDouble = false;
		System.out.print("Enter a number:  ");
		do {
			sResult = scanner.next();
			try {
				result = Double.parseDouble(sResult);
				isDouble = true;
			}catch(NumberFormatException nfe){
				System.out.println("Oooops, that doesnt seem to be a number...");
				System.out.println("Try again!");
			}
		}while(!isDouble);
	return result;
	}//close getInteger


}//close class