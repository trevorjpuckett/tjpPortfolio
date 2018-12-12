/* Trevor J Puckett
	11/19/2018   */

/******************************* PROMPT *******************************************************************
	Write a Java program that will ask the user for a starting number, an ending number, and an increment number.
	The program will then count upward, from the starting number up to and including the ending number,
	by the increment number, displaying each number on a separate line.
	Also, for each displayed number, the program will say whether the number is even or odd.
	This program will require the use of a loop as well as the “if/else” statement.
	Examine the sample outputs carefully in order to structure your code in a logical manner.

					Your program must include the below methods:
						  getStartNum( ) //returns an int
						  getEndNum( ) //returns an int
						  getIncrNum( ) //returns an int
	   					 calculateOddEven( ) //returns a boolean and accepts an integer ***There should be no print statements in this method.
						 print() //does not return a value and accepts a string (odd or even) and an integer

			Issue your method calls from main print the results only from the print method.


								Here is a sample run of the program:

									Please enter a starting number: 3
									Please enter an ending number: 19
									Please enter an increment number: 3

 									The number 3 is odd
									The number 6 is even
									The number 9 is odd
									The number 12 is even
									The number 15 is odd
									The number 18 is even
									Thanks for playing!

								Here is another sample run:

									Please enter a starting number: 5
									Please enter an ending number: 30
									Please enter an increment number: 4

									The number 5 is odd
									The number 9 is odd
									The number 13 is odd
									The number 17 is odd
									The number 21 is odd
									The number 25 is odd
									The number 29 is odd
									Thanks for playing!


******************************* END OF PROMPT ***************************************************************/

import java.util.Scanner;

public class CountingUpwards{

	static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args){
		run();
	}//close main

	static void run(){
		int total = 0;
		int startNum = getStartNum();
		int endNum = getEndNum();
		int incrNum = getIncrNum();

		total = startNum;
		System.out.println();
		while(endNum > total){
			print(total, setNumericIdentifier(decideOddEven(total)));
			total += incrNum;
		}
		System.out.println("Thanks for playing!");
	}//close run

	static void print(int printVal, String printNumId){
		System.out.printf("The number %d is %s%n", printVal, printNumId);
	}//close print


	static String setNumericIdentifier(boolean isOdd){
		String numID = "";
		if(isOdd){
			numID = "odd";
		} else{
			numID = "even";
		}
	return numID;
	}//close setNumericIdentifier

	static boolean decideOddEven(int value){
		boolean isOdd = false;
		if ((value % 2) > 0) {
			isOdd = true;
		}
	return isOdd;
	}//close decideOddEven

	static int getIncrNum(){
		int tempIncrNum = 0;
		System.out.print("Enter the number you would like to increment by:  ");
		tempIncrNum = getInteger();
	return tempIncrNum;
	}//close getStartNum


	static int getEndNum(){
		int tempEndNum = 0;
		System.out.print("Enter the number you would like to end at:  ");
		tempEndNum = getInteger();
	return tempEndNum;
	}//close getStartNum

	static int getStartNum(){
		int tempStartNum = 0;
		System.out.print("Enter the number you would like to start at:  ");
		tempStartNum = getInteger();
	return tempStartNum;
	}//close getStartNum

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