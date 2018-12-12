/* Trevor J Puckett
		11/28/2018	*/

/********************** PROMPT ********************************************

	Write a program that takes 5 numbers and outputs the mean and standard deviation.
	for numbers x1,x2,x3,x4,x5
		mean = x1+x2+x3+x4+x5
		SD = [((x1-x)^2+(x2-x)^2+(x3-x)^2+(x4-x)^2+(x5-x)^2)^(1/2)]/n
			where x = mean, n = number of inputs


****************** END OF PROMPT **************************************/

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MathStuff{

	static Scanner scanner = new Scanner(System.in);
	static List<Double> variables = new ArrayList<>();


	public static void main(String[] args){
		run();

	}//close main

	static void run(){

		 boolean timeToQuit = false;
		 String choice = "";
		 do {
		 	System.out.println("Would you like to claculate a new standard deviation? ( yes / no )");
		 	choice = scanner.next();
		 	switch(choice){
				case "yes":
					performMath();
					break;
				case "no":
					timeToQuit = true;
					break;
				default:
					System.out.printf("I have no idea what you entered... Okay i lied.. You typed %s.%n"
										+"I was looking for yes or no.. Try again!", choice);
					break;
			}
		 }while(!timeToQuit);
	}
	static void performMath(){
		 double mean = 0;
		// double standardDeviation = 0;
		 clearVariables();
		 getVariables();
		 printAllVariables();
		 mean = calcMean(variables, variables.size());
		 calcStandardDeviation(variables, mean, variables.size());
		 System.out.printf("%n*********************************************%n%n");
	}
	static void calcStandardDeviation(List<Double> varbs, double x, double n){
		double sum = 0;
		double sd = 0;
		for(double var : varbs){
			sum += Math.pow((var-x),2);
		}
		sd = Math.sqrt(sum/n);
		System.out.printf("%nThe standard deviation is: %.2f",sd);
	}//close calcStandardDeviation


	static double calcMean(List<Double> varbs, double n){
		double sum = 0;
		double mMean = 0;
		for(double variable : variables){
			sum += variable;
		}
		mMean = sum/n;
		System.out.printf("%nThe mean of is: %.2f", mMean);
	return mMean;
	}//close calcMean

	static void getVariables(){
		boolean noMoreVariables = false;
		List<Double> newVariables = new ArrayList<>();
		System.out.println("Enter in as many numbers as you would like, type 0 when you are finsihed entering in values.");
		do{
			System.out.print("Enter a number:  ");
			double variable = getDouble();
			switch((int)variable){
				case 0:
					noMoreVariables = true;
					break;
				default:
					newVariables.add(variable);
			}
		}while(!noMoreVariables);
		variables.addAll(newVariables);

	}//close getVariables

	static void clearVariables(){
			List<Double> currentVariables = new ArrayList<>();
			for(double variable : variables){
				currentVariables.add(variable);
			}
			variables.removeAll(currentVariables);
			//System.out.println("Everything has been removed..");
	}//close clearDeck

	static void printAllVariables(){
		System.out.print("You've entered: ");
		for(double variable : variables){
			System.out.printf(" %.2f",variable);
		}
	}//close printAllVariables

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

}//close class