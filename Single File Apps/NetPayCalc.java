/* Trevor Puckett
	11/7/2018 */


/******************************* PROMPT **********************************************
	write a program that calculates and prints the monthly paycheck for an employee.
	The net pay is calculated after taking the following deductions :
		federal income tax (15%), state tax(3.5%), social security tax(5.75%),
		Medicare/Medicaid tax(2.75%), pension plan(5%), heal insurance($75)
************************** END OF PROMPT **************************************************/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NetPayCalc {

		static final double FEDERAL_INCOME_TAX = .15;
		static final double STATE_TAX = .035;
		static final double SOC_SEC_TAX = .0575;
		static final double MEDI_TAX = .0275;
		static final double PENSION_PLAN = 0.05;
		static final double HEALTH_INSUR = 75.00;
		static List<String> employeeDetails = new ArrayList<>();

	public static void main(String[] args){
		employeeDetails = importEmployeeDetailsFrom("ch3_EmpData.txt");
	/*	for(String employeeDetail : employeeDetails){
			System.out.println(employeeDetail);
		} */

	}//close main

/************************ IMPORT EMPLOYEE DETAILS *******************************/
	static List<String> importEmployeeDetailsFrom(String fileName){
		List<String> tempEmployeeDetails = new ArrayList<>();
		try(FileInputStream stream = new FileInputStream(fileName);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
	        ){
				String line;
				while((line = reader.readLine()) != null) {
					tempEmployeeDetails.add(line);
				}
		}catch(IOException ioe) {
	      System.out.printf("Problem Loading %s %n", fileName);
	      ioe.printStackTrace();
	    }
	return tempEmployeeDetails;
	}//close importEmployeeDetails

	}//close class

/**************************** CALC NET PAY ***************************************/
	static double calcNetPay(double salary){
		double mult = 1 - FEDERAL_INCOME_TAX - STATE_TAX - SOC_SEC_TAX - MEDI_TAX - PENSION_PLAN;
		double netSalary = (salary * mult) - HEALTH_INSURANCE;
	return netSalary;
	}//close calcNetPay

