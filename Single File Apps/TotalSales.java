/* Trevor J Puckett
		11/19/2018	*/

/************************************ PROMPT ***********************************************************************

	You just got an internship at MTC's bookstore.
	One of your jobs is to track book sales.
	Write a program that allows you to input total book sales for each day (7 days) of the week.
	The amounts should be stored in an array. Use a loop to calculate the total sales for the week.
	You should then display the daily sales and total sales. See the example below:

			Make sure to document your program and Submit your source code to this dropbox.
									Weekly Book Sales
									Monday - $125.00
									Tuesday - $135.00
									Wednesday - $110.00
									Thursday - $125.00
									Friday - $135.00
									Saturday - $110.00
									Sunday - $250.00
									Total Sales = $990.00

********************************* END OF PROMPT *****************************************************************/

import java.util.Scanner;

public class TotalSales{

	static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args){
		run();

	}//close main
	static void run(){
		double[] weeklySales = getWeeklySales();
		double totalSales = 0;
		int index = 0;
		System.out.printf("%n%n%nWeek Book Sales%n"
							+"_______________________%n");
		for(double daySales : weeklySales){
			System.out.printf("%s - $%.2f%n",getCurrentDay(index),daySales);
			totalSales += daySales;
			index++;
		}
		System.out.println("Total Weekly Sales:  "+totalSales);
	}//close run
	static double[] getWeeklySales(){
		double[] tempWeeklySales = {0, 0, 0, 0, 0, 0, 0};
		for(int x=0; x < 7; x++) {
			 tempWeeklySales[x] = getSalesForTheDay(getCurrentDay(x));
		}
	return tempWeeklySales;
	}//close getWeeklySales

	static String getCurrentDay(int index){
		String currentDay = "";
		switch(index){
			case 0:
				currentDay = "Monday";
				break;
			case 1:
				currentDay = "Tuesday";
				break;
			case 2:
				currentDay = "Wednesday";
				break;
			case 3:
				currentDay = "Thursday";
				break;
			case 4:
				currentDay = "Friday";
				break;
			case 5:
				currentDay = "Saturday";
				break;
			case 6:
				currentDay = "Sunday";
				break;
		}

	return currentDay;
	}//close getCurrentDay

	static double getSalesForTheDay(String currentDay){
		double totalDaysSales = 0;
		boolean noMoreSales = false;
		double singleSale = 0;
		System.out.printf("%n%nCongrats! You made it through another %s!%n", currentDay);
		System.out.println("Enter all of the sales for today, enter in 0 when you have entered in all of the sales for today.");
		do{
			System.out.printf("Enter sales amount, or a 0 if you are finished:  ");
			singleSale = getDouble();
			int saleIndex = (int)singleSale;
			switch(saleIndex){
				case 0:
					noMoreSales = true;
					break;
				default :
					totalDaysSales += singleSale;
					break;
			}
		}while(!noMoreSales);
	return totalDaysSales;
	}//close getSalesForTheDay


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

}//close main