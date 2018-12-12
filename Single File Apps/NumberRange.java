/* Trevor Puckett
     10/29/2018    */

 import java.util.Scanner;

 /*					*****	OBJECTIVE STATEMENT	*****
 	Write a program that prompts the user to input an integer between 0 and 35 (inclusive).
	If the number is less than or equal to 9, the program should output the number multiply by 4;
	otherwise, if the number is even, return the number,
	if the number is odd, divide the number by 3 and return the remainder of the number.
 	Any number outside of the requested range, should receive a message stating invalid number and the number.
 				    *****	END OBJECTIVE STATEMET *****															*/

public class NumberRange{

	static Scanner scanner = new Scanner(System.in);
	static final int UNDER_NINE_MULT = 4;
	static final int ODD_DIVIDER = 3;
	static boolean timeToQuit = false;

	public static void main(String[] args){
		//nailed it
		do {
			run(UNDER_NINE_MULT, ODD_DIVIDER);
			promptRepeat();
		} while (!timeToQuit);

	}//close main

	static void promptRepeat(){
		boolean moveOn = false;
		String answer = "";
		do{
			System.out.println("Would you like to try another number?(yes or no)");
			answer = scanner.next().toLowerCase().trim();
			switch(answer){
				case "yes":
					System.out.printf("Okay cool! Let's go again!%n%n"
									  +"***********************************************************************************%n%n");
					moveOn = true;
				break;
				case "no":
					System.out.println("Okay, bye!");
					timeToQuit = true;
					moveOn = true;
				break;
				default:
					System.out.println("I don't know what that was... Please enter yes or no.");
				break;
			}
		}while(!moveOn);

	}//close promptRepeat
	static void run(int under_nine_mult, int odd_divider){
		int number = promptInput();
		if(number <= 9){
			number *= under_nine_mult ;
		} else if((number % 2) != 0){
			number %= odd_divider;
		  } else {
			  number = number;
		  }
		System.out.printf(number);
	}//close run

	static int promptInput(){
		String userInput = "";
		int number = 0;
		boolean isAcceptable = false;
			do{
				System.out.print("Please enter a number between 0 and 35:  ");
				try {
					userInput = scanner.next();
					number  = isNumber(userInput);
					verifyConditions(number);
					isAcceptable = true;
				}catch (IllegalArgumentException iae) {
						System.out.printf("%s %n%n",iae.getMessage());
					}
		}while(!isAcceptable);


	return number;
	}//close promptInput

	static int isNumber(String input){
		int number = 0;
		boolean isNumber = false;
		try{
			number = Integer.parseInt(input);
			isNumber = true;
		}catch (Exception e) {
			isNumber = false;
		   }
			if(!isNumber){
				throw new IllegalArgumentException( input +" is not an integer... Please enter an integer.");
			}
		return number;
	}//close isNumber

	static void verifyConditions(int number){
		if(number < 0){
			throw new IllegalArgumentException("Ooops.. " +number +" is below 0. Please enter a number above 0, but below 35.");
		}
		if(number > 35){
			throw new IllegalArgumentException("Ooops.. "+number+" is above 35. Please enter a number below 35, but above 0.");
		}
	}//close verifyConditions

}//close class