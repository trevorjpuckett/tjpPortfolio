//Trevor Puckett
//imports
import java.io.*;
import java.util.*;

public class EmployeeRaise {


		//main method
	public static void main(String args[]){
		List<String> employeeDetails = new ArrayList<>();
		employeeDetails = importFrom("employeeRaise.txt");
		exportTo("employeeRaiseOutput.txt",employeeDetails);
			System.out.println("The new employee salaries have been calculated and stored in employeeRaiseOutput.txt");
	}

		// method for importing information from a file
	public static List<String> importFrom(String fileName) {
		List<String> args = new ArrayList<>();
		try(FileInputStream stream = new FileInputStream(fileName);
	      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
	    ){
			String line;
			while((line = reader.readLine()) != null) {
				args.add(line);
			}
		}catch(IOException ioe) {
	      System.out.printf("Problem Loading %s %n", fileName);
	      ioe.printStackTrace();
	    }
		return args;
	}
		//method to format & emport the imported information.
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
	}
		//method to calculate salary
	public static double calcNewSalary(double mult, double salary){
		double newSalary = salary + (salary*(mult/100));
		return newSalary;
	}
	//method to ensure capitalization if there is a typo.
	public static String capitalize(String name) {
		String nameInt = name.substring(0,1).toUpperCase();
		String nameCap = nameInt + name.substring(1).toLowerCase();
		return nameCap;
	}

}