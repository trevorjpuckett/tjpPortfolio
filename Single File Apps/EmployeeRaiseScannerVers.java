/* Trevor J Puckett
	10/6/2018 		*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeRaiseScannerVers {


	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){

	exportTo("employeeRaiseOutput.txt", importEmployeeDetails("employeeRaise.txt"));
	System.out.println("Working on it... Update complete. Please check the employeeRaiseOutput.txt file for the new salary amounts.");


	}//close main

	static List<String> importEmployeeDetails(String filename){
		List<String> tempEmployeeDetails = new ArrayList<>();
		String line = "";
		try {
			scanner = new Scanner(new File(filename));
			while (scanner.hasNext()){
				line = scanner.nextLine();
				tempEmployeeDetails.add(line);
			}
			scanner.close();
		} catch(FileNotFoundException fnfe){
				System.out.println(fnfe.getMessage());
				fnfe.printStackTrace();
			}
	return tempEmployeeDetails;
	}//close import
	public static void exportTo(String fileName, List<String> details) {
		try(FileOutputStream stream = new FileOutputStream(fileName);
		      PrintWriter writer = new PrintWriter(stream);
		){
			writer.printf("The new employee salaries: %n%n");
			//split up the line to get employee specific details
			for(String detail : details){
				String args[] = detail.split("\\s+");
				String fName = capitalize(args[0]);
				String lName = capitalize(args[1]);
				double mult = Double.parseDouble(args[2]);
				double salary = Double.parseDouble(args[3]);
				double newSalary = calcNewSalary(mult, salary);
				writer.printf("%s, %s $%,.2f %n",lName, fName, newSalary);
			}
		}catch(IOException ioe) {
	      System.out.printf("Problem Loading %s %n", fileName);
	      ioe.printStackTrace();
	    }
	}//close export
		//method to calculate salary
	public static double calcNewSalary(double mult, double salary){
		double newSalary = salary + (salary*(mult/100));
		return newSalary;
	}//close calcNewSalary
	//method to ensure capitalization if there is a typo.
	public static String capitalize(String name) {
		String nameInt = name.substring(0,1).toUpperCase();
		String nameCap = nameInt + name.substring(1).toLowerCase();
		return nameCap;
	}//close capitalize




}//close class