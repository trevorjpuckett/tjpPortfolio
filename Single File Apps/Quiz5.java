/* Trevor J Puckett
		11/11/2018   */

/**************************************** PROMPT **********************************************************************************************
		Write a program to Calculate the body fat percentage of a person: Your program should be efficient.
		For example, both genders require body weight, you should not have two different variables for body weight.
		For our convenience, a word document is attached.
			WOMEN : Body fat formula for women:
				A1 = (Body weight * 0.732) + 8.987
				A2 = Wrist measurement/3.140
				A3 = Waist Measurement * 0.157
				A4 = Hip Measurement * 0.249
				A5 = Forearm Measurement * 0.434
				B = A1 + A2 – A3 – A4 + A5
				Body fat = body weight – B
				Body fat percentage = body fat * 100 / Body weight
			MEN: Body fat formula for men:
				A1 = (Body weight * 1.082) + 94.42
				A2 = Waist measurement * 4.15
				B = A1 - A2
				Body fat = body weight – B
				Body fat percentage = body fat * 100 / body weight
********************************** END OF PROMPT *******************************************************************************************/

import java.util.*;

public class BodyFatCalc {

	static Scanner scanner = new Scanner(System.in);
	static boolean timeToQuit = false;


	public static void main(String[] args){
		do{
			switch(promptGender().trim().toLowerCase()){
				case "male":
					promptUnknowns("male");
				break;
				case "female":
					promptUnknowns("female");
				break;
				case "quit":
					timeToQuit = true;
				break;
				default:
					System.out.println("Unknown entry, please try again!");
				break;

			}
	}while(!timeToQuit);

	}// close main

	 static String promptGender(){
		 System.out.println("Please enter your gender as follows: Male / Female");
		 System.out.println("Or, enter quit if you would like to quit.");
		 String gender = scanner.next();
	 return gender;
	 }//close promptGender

	 static void promptUnknowns(String gender){
		 if (gender.equals("male")){
			 System.out.println("You entered male!");
		 } else {
			 System.out.println("You entered female!");
		 	}
	 }//close promptUnkowns

}//close class