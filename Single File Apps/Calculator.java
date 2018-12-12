/* Trevor J Puckett
		11/18/2018	*/

/********************************************* PROMPT *******************************************************************
	Write a program that ask the user for 2 integers and a character (sign +, -, *, /, %).
	Write functions for each of the signs addition, subtraction, multiplication.
	Your function should return a integer and accept 2 parameters of type int.
	Using either the if or switch construct, you should determine which method to use based on the sign the user enter.

			For example: the user enter 4, 6, *.
			You will call the multiplication method.

			You should print the result from the main method.
			Something like Result: 4 * 6 = 24

												Have Fun!

******************************************* END OF PROMPT *****************************************************************/

import java.util.Scanner;

public class Calculator {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
			run();
		}//close main

 	 static double getDouble(){
 		 String sResponse = "";
 		 double response = 0;
 		 boolean isDouble = false;
 		 do {
			 System.out.print("Enter a number:  ");
 			 sResponse = scanner.next().trim();
 			 try{
 				response = Double.parseDouble(sResponse);
 				isDouble = true;
 			 }catch(NumberFormatException nfe){
 				 System.out.println(sResponse + " doesn't seem to be a number..");
 				 System.out.println("Please try again:");
 			 }
 		 }while(!isDouble);
 	 return response;
 	 }//close getDouble

 	 static double runMath(){
		double num1 = 0;
		double num2 = 0;
		String operator = "";
		boolean verifiedOperator = false;
		double total = 0;
		do{
			num1 = getDouble();
			System.out.print("Enter the mathematical operator:  ");
			operator = scanner.next();
			num2 = getDouble();
			switch (operator){
				case "+":
					total = num1 + num2;
					verifiedOperator = true;
					break;
				case "-":
					total = num1 - num2;
					verifiedOperator = true;
					break;
				case "*":
					total = num1 * num2;
					verifiedOperator = true;
					break;
				case "/":
					total = num1 / num2;
					verifiedOperator = true;
					break;
				case "%":
					total = num1 % num2;
					verifiedOperator = true;
					break;
				default:
					System.out.printf("Your operator seems to be incorrect... %n"
										+ "Please choose from: +, -, *, /, %% %n");
			}
		}while(!verifiedOperator);
	  return total;
	 }//close runMath

	static void run(){

		String choice = "";
		boolean timeToQuit = false;

		do{
			System.out.println("Would you like to perform a function? ( yes / no )");
			choice = scanner.next().trim().toLowerCase();
			switch (choice){
				case "yes":
					double total = runMath();
					System.out.printf("Your total is: %.2f %n%n",total);
					break;
				case "no":
					System.out.println("See you next time!");
					timeToQuit = true;
			}
		} while(!timeToQuit);


	}//close run

}//close class



/******************** SCRATCH TO GO BACK TO ******************************************************************


	static void loadFunctionToPerform(String functionStream){
		//clearFunctionToPerform();
		//String[] functionStreamArray = functionStream.split("(?<=[-+*()/])|(?=[-+*()/])");
		for(String element : functionStreamArray){
			functionToPerform.add(element);
		}
	}//close loadFunctionToPerform

	static void performFunction(List<String> functionToPerform){


	}//close performFunction

****************************************************************************************************************/