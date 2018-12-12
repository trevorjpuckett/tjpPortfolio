package com.tjp.consolePrograms.singleFiles.Rainfall;/* Trevor J Puckett
		12/3/2018	*/

/************************************************** PROMPT *****************************************************

			With the curiosity of a cat, you decided to track the rainfall.
			Remembering the rain gauge you built in elementary school, you sat it on the deck of your home.
			Then you decided to design a program that allowed you to enter the total rainfall for each month (12) into an array.
					Your program calculates and displays the total rainfall for the year,
						the average monthly rainfall,
						and the highest month rainfall
						and the lowest month rainfall.
			Each of the above bold topics is a method that accepts an array object and returns the appropriate value.

			Make sure to document your work and submit your source code to this dropbox.

*********************************************** END OF PROMPT ***************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RainFall{

	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, List<Double>> recordedRainfall = new HashMap<>();
	static Map<String, String> mMenu =  new TreeMap<>();

	/*public static void main(String[] args){
		run();
	}//close main */
	public RainFall(){

	}

	static void run(){
		boolean timeToQuit = false;
		createMenu();
		do{
			optionMenu(mMenu);
			String choice = scanner.next().trim().toLowerCase();
			switch(choice){
				case "print":
					printMapContents();
					break;
				case "add":
					enterData();
					break;
				case "calc":
					calcYearlyStats();
					break;
				case "quit":
					timeToQuit = true;
					break;
				default:
					System.out.println("Try again.");
					break;
			}
		}while(!timeToQuit);

	}//close run

	static void optionMenu(Map<String,String> menu){
		System.out.printf("Your options are: %n%n");
		for(Map.Entry<String, String> option : menu.entrySet()){
			System.out.println(option.getKey() + ", " + option.getValue());
		}
		System.out.print("Enter what you would like to do:  ");
	}//close optionMenu

	static void createMenu(){
		mMenu.put("Print","Print all stored data.");
		mMenu.put("Add","Add new data");
		mMenu.put("Calc","Run the calculations");
		mMenu.put("Quit","quit the program.");
	}//close createMenu

	static void calcYearlyStats(){
		System.out.printf("%n%n                                     Yearly Stats%n"
							+ "_________________________________________________________________________________%n%n");
		for(Map.Entry<Integer,List<Double>> entry : recordedRainfall.entrySet()) {
			double sum = 0;
			double average = 0;
		  int key = entry.getKey();
		  System.out.printf("For %d the average was:",key);
		  for (double monthRain : entry.getValue()) {
			  sum += monthRain;
		  }
		  average = sum / 12;
		  System.out.printf(" %.2f. ",average);
		  System.out.printf(" And the most rain fell in %s.%n",getWettestMonth(entry.getValue()));
		}


	}//close calcYearlyStats

	static String getWettestMonth(List<Double> tempMonths){
		int limit = tempMonths.size();
		double max = Double.MIN_VALUE;
		int maxPos = -1;
		for (int i = 0; i < limit; i++) {
		    double value = tempMonths.get(i);
		    if (value > max) {
		        max = value;
		        maxPos = i;
		    }
		}
		String month = getMonth(maxPos);
		return month;
	}//close getWettestMonth

	static void enterData(){
		int year = promptYear();
		boolean moreData = false;
			if(!recordedRainfall.containsKey(year)){
				addYearData(year);
			} else{
				changeMonthData(year);
			}

	}//close enterData

	static void changeMonthData(int year){
		double rainfall = 0;
		int monthIndex = promptMonth();
		String month = getMonth(monthIndex);
		System.out.printf("Enter the rainfall for %s, %d: ",month, year);
		rainfall = getDouble();
		recordedRainfall.get(year).set(monthIndex, rainfall);

	}//close changeMonthData
	static void printMapContents(){
		System.out.println("      Jan  |  Feb  |  Mar  |  Apr  |  May  |  Jun  |  Jul  |  Aug  |  Sep  |  Oct  |  Nov  |  Dec  |");
		for(Map.Entry<Integer,List<Double>> entry : recordedRainfall.entrySet()) {
		  int key = entry.getKey();
		  System.out.printf("%n%d:",key);
		  for (double monthRain : entry.getValue()) {
		    System.out.printf("  %.2f |",monthRain);
		  }
		}
	System.out.println();
	}//close printMapContents

	static void addYearData(int year){
		recordedRainfall.put(year, createYearlyRainFallLog());
	}//close addYearData

	static List<Double> createYearlyRainFallLog(){
		List<Double> tempYearlyData = new ArrayList<>();
		for(int x = 0; x < 12 ; x++){
			String month = getMonth(x);
			System.out.printf("%nEnter the rainfall for %s: ",month);
			double rainfall = getDouble();
			tempYearlyData.add(rainfall);
		}
	return tempYearlyData;
	}//close yearlyRainFall

	static int promptYear(){
		int year = 0;
		System.out.print("Enter the year: ");
		year = getInteger();
	return year;
	}//close promptYear

	static String getMonth(int index){
		String month = "";
		switch(index){
			case 0:
				month = "Jan";
				break;
			case 1:
				month = "Feb";
				break;
			case 2:
				month = "Mar";
				break;
			case 3:
				month = "Apr";
				break;
			case 4:
				month = "May";
				break;
			case 5:
				month = "Jun";
				break;
			case 6:
				month = "Jul";
				break;
			case 7:
				month = "Aug";
				break;
			case 8:
				month = "Sep";
				break;
			case 9:
				month = "Oct";
				break;
			case 10:
				month = "Nov";
				break;
			case 11:
				month = "Dec";
				break;
			}
		return month;
	}

	static int promptMonth(){
		int monthIndex = 0;
		boolean isMonth = false;
		do {
			System.out.print("Enter the first 3 letters of the month you would like to input data for: ");
			String month = scanner.next();
						switch(month){
							case "jan":
								monthIndex = 0;
								isMonth = true;
								break;
							case "feb":
								monthIndex = 1;
								isMonth = true;
								break;
							case "mar":
								monthIndex = 2;
								isMonth = true;
								break;
							case "apr":
								monthIndex = 3;
								isMonth = true;
								break;
							case "may":
								monthIndex = 4;
								isMonth = true;
								break;
							case "jun":
								monthIndex = 5;
								isMonth = true;
								break;
							case "jul":
								monthIndex = 6;
								isMonth = true;
								break;
							case "aug":
								isMonth = true;
								monthIndex = 7;
								break;
							case "sept":
								isMonth = true;
								monthIndex = 8;
								break;
							case "oct":
								isMonth = true;
								monthIndex = 9;
								break;
							case "nov":
								isMonth = true;
								monthIndex = 10;
								break;
							case "dec":
								isMonth = true;
								monthIndex = 11;
								break;
							default:
								System.out.printf("Sorry.. I don't understand. Please enter a month in the format as such:"
													+ "%nIf you want to enter a value for March, you would enter mar%n");
								break;
							}
		}while(!isMonth);
	return monthIndex;
	}//close promptMonth


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

}