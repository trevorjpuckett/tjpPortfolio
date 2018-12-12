/* Trevor Puckett
		11/26/2018	*/

import java.util.Random;
import java.util.Scanner;

public class ArraysClass {


	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		runArrayLoop();

	}//close main

	static void runArrayLoop(){
		String response = "";
		boolean timeToQuit = false;
		do{
			response = promptInterest();
			switch(response){
				case "yes":
					arrayLoop();
					break;
				case "no":
					timeToQuit = true;
					break;
				default:
					System.out.println("Idk what you just typed.. Please enter yes, or no.");
					break;
			}
		}while(!timeToQuit);
	}//close runArrayLoop

	static void arrayLoop(){
		int total = 0;
		int totalOdd = 0;
		int amount = 0;
		int[] numberArray = new int[promptForNumber()];
		for(int i = 0; i<numberArray.length; i++){
		numberArray = loadArray(numberArray);
		printArrayContents(numberArray);
		total += sumArrayContents(numberArray);
		amount += 1;
		totalOdd += sumArrayOddContents(numberArray);
		System.out.printf("***********************************%n");
		}
		getAverage(total, amount, " ");
		getAverage(totalOdd, amount, " odd ");
		System.out.println();
	}//close run

	static int promptForNumber(){
		int response = 0;
		System.out.print("Please enter an integer: ");
		response = getInteger();
	return response;
	}//close promptForNumber;

	static String promptInterest(){
		String response = "";
		System.out.println("Would you like to loop through some sums? ( yes / no )");
		response = scanner.next();
	return response.trim().toLowerCase();
	}//close promptInterest


	static int[] loadArray(int[] tempArray){
		for(int i = 0; i<tempArray.length; i++){
			tempArray[i] = rnd.nextInt(tempArray.length);
		}
	return tempArray;
	}//close loadArray

	static int[] clearArray(int[] tempArray){
		for(int i = 0; i< tempArray.length; i++){
			tempArray[i] = 0;
		}
	System.out.println("Array has been reset to 0.");
	return tempArray;
	}//close clearArray

	static void printArrayContents(int[] printableArray){
		for(int number : printableArray){
			System.out.printf("%d ", number);
		}
	}//close printArrayContents

	static int sumArrayOddContents(int[] sumableArray){
		int sum = 0;
		for (int number : sumableArray){
			if((number % 2) != 0)
			sum += number;
		}
		System.out.printf("The odd numbers in this array sum to: %d%n",sum);
	return sum;
	}//close sumArrayOddContents

	static int sumArrayContents(int[] sumableArray){
		int sum = 0;
		for (int number : sumableArray){
			sum += number;
		}
		System.out.printf("%nSums to: %d%n",sum);
	return sum;
	}//close sumArrayContents

	static void getAverage(int total, int amount,String id){
		int average = total / amount;

		System.out.printf("%nThe total of all%ssums: %d %nThe average%ssum is: %d", id, total, id, average);
	}//close getAverage

	static int getInteger(){
		 String sResponse = "";
		 int response = 0;
		 boolean isInteger = false;
		 do {
			 sResponse = scanner.next().trim();
			 try{
				response = Integer.parseInt(sResponse);
				isInteger = true;
			 }catch(NumberFormatException nfe){
				 System.out.println(sResponse + " doesn't seem to be a number..");
				 System.out.println("Please try again:");
			 }
		 }while(!isInteger);
	 return response;
	 }//close getInteger


}//close class