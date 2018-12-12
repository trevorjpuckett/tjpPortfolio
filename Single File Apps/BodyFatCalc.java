/* Trevor J Puckett
		11/11/2018   */

/**************************************** PROMPT **********************************************************************************************
		Write a program to Calculate the body fat percentage of a person: Your program should be efficient.
		For example, both genders require body weight, you should not have two different variables for body weight.
		For our convenience, a word document is attached.
			WOMEN : Body fat formula for women:
				A1 = (Body weight * 0.732) + 8.987
				A2 = Waist Measurement * 0.157
				A3 = Wrist measurement/3.140
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
import java.io.*;
import java.util.*;

public class BodyFatCalc {

	static Scanner scanner = new Scanner(System.in);
	static boolean timeToQuit = false;

		static double bodyWeight = 0;
		static double B = 0;

		static double waistMeas = 0;
		static double wristMeas = 0;
		static double hipMeas = 0;
		static double forearmMeas = 0;

		static double bodyFat = 0;
		static double bodyFatPercentage = 0;


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
		 System.out.println("To calculate your body fat");
		 System.out.println("please enter your gender as follows: Male / Female");
		 System.out.printf("Or, enter quit if you would like to quit.%n");
		 String gender = scanner.next();
	 return gender;
	 }//close promptGender

	 static void promptUnknowns(String gender){
		 if (gender.equals("male")){
			 System.out.printf("%n%n Enter your body weight in pounds:   ");
			 	bodyWeight = getDouble();
			 System.out.printf("%n Enter your waist measurment:  ");
			 	waistMeas = getDouble();
			 System.out.printf("%nThank You%n*************************************************************** ");
			 calcBodyFat(gender);
		 } else {
			 System.out.printf("%n%n Enter your body weight:  ");
			 	bodyWeight = getDouble();
			 System.out.printf("%n Enter your waist measurment:  ");
			 	waistMeas = getDouble();
			 System.out.printf("%n Enter your wrist measurment:  ");
			 	wristMeas = getDouble();
			 System.out.printf("%n Enter your hip measurment:  ");
			 	hipMeas = getDouble();
			 System.out.printf("%n Enter your forearm measurment:  ");
			 	forearmMeas = getDouble();
			System.out.printf("%nThank You%n*************************************************************** ");
			calcBodyFat(gender);
			}
	 }//close promptUnkowns

	 static double getDouble(){
		 String sResponse = "";
		 double response = 0;
		 boolean isDouble = false;
		 do {
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

	 static void calcBodyFat(String gender){
		 double a1Mult = 0;
		 double a1Additive = 0;
		 double a2Mult = 0;

		 double a3Divider = 3.149;
		 double a4Mult = 0.249;
		 double a5Mult = 0.434;

		 double a1 = 0;
		 double a2 = 0;

		 double a3 = 0;
		 double a4 = 0;
		 double a5 = 0;

		 if (gender.equals("male")){
			 a1Mult = 1.082;
			 a1Additive = 94.42;
			 a2Mult = 4.15;

			 a1 = (bodyWeight * a1Mult) + a1Additive;
			 a2 = waistMeas * a2Mult;
			 B = a1 - a2;
			 calcFat(bodyWeight,B);
		 } else {
			 a1Mult = 0.732;
			 a1Additive = 8.987;
			 a2Mult = 0.157;

			 a1 = (bodyWeight * a1Mult) + a1Additive;
			 a2 = waistMeas * a2Mult;
			 a3 = wristMeas / a3Divider;
			 a4 = hipMeas * a4Mult;
			 a5 = forearmMeas * a5Mult;
			 B = a1 + a2 - a3 - a4 + a5;
			 calcFat(bodyWeight,B);

		 }

	 }//close calcBodyFat

	 static void calcFat(double bodyweight, double b){
		 bodyFat = bodyweight - b;
		 bodyFatPercentage = (bodyFat/bodyWeight)*100;
		 System.out.printf("%nYour body fat percentage:  %.2f%% %n%n", bodyFatPercentage);
	 }//close calcFat

}//close class