/* Trevor J Puckett
		11/14/2018	*/

/************************************ PROMPT ****************************************************************************
Write an application that reads an integer value from the user and prints the sum of all even integers
between 2 and the input value, inclusive. Print an error message if the input value is less than 2.
Example 1:
the user enters 14
Output: Sum: 56
Example 2:
the user enters 1
Output: Error number must be greater than 1

********************************** END OF PROMPT ********************************************************************/

import java.util.*;

public class LoopingContinued {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		funkyMathStuff();


	}//close main

	static void funkyMathStuff(){
		int number = getInt();
		System.out.println("You entered: "+number);
		int sum = 0;
		int newNumber = 0;
		if((number%2) != 0){
				newNumber = number - 1;
		} else {
				newNumber =  number;
			}
		//sum = newNumber;
		for(int x = newNumber; x > 1; x -= 2){
			sum+=x;
		}
		System.out.println("Output sum:  " + sum);
	}//close funkyMathStuff

 	 static int getInt(){
 		 String sResponse = "";
 		 int response = 0;
 		 boolean isInteger = false;
 		 do {
			 System.out.print("Enter a number:  ");
 			 sResponse = scanner.next().trim();
 			 try{
 				response = Integer.parseInt(sResponse);
 				if (response > 1){
 					isInteger = true;
				} else {
					System.out.println("Error, please enter a number greater than 1.");
				}
 			 }catch(NumberFormatException nfe){
 				 System.out.println(sResponse + " doesn't seem to be a number..");
 				 System.out.println("Please try again:");
 			 }
 		 }while(!isInteger);
 	 return response;
 	 }//close getDouble

}//close class