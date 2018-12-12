/* Trevor Puckett
	11/7/2018  */

/**************************** PROMPT ************************************************************************
	Write a program to input a number of students, then to input a grade for each student
	and to count the A's, B's, C's, D's, and F's and display the counts.
	Initialize 5 variables, for a, b, c, d, and f, all to 0,
	then use if statements to decide which of the 5 to increment, all in the body of a loop.
		The grading scale is:
			93-100 A Superior Work
			85-92 B Good Work
			77-84 C Average Work
			70-76 D Needs Improvement
			0-69 F Unsatisfactory Work
******************************** END OF PROMPT *********************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loops {

	static Scanner scanner = new Scanner(System.in);
	static List<Double> studentGrades = new ArrayList<>();
		static int amntOfAs = 0;
		static String letterA = "A";
		static int amntOfBs = 0;
		static String letterB = "B";
		static int amntOfCs = 0;
		static String letterC = "C";
		static int amntOfDs = 0;
		static String letterD = "D";
		static int amntOfFs = 0;
		static String letterF = "F";

	public static void main(String[] args){
		getStudentGrades();
		System.out.printf("There are %d %s, %d %s, %d %s, %d %s, and %d %s.%n%n ",
							 amntOfAs, pluralize(letterA,amntOfAs),
							 amntOfBs, pluralize(letterB,amntOfBs),
							 amntOfCs, pluralize(letterC,amntOfCs),
							 amntOfDs, pluralize(letterD,amntOfDs),
							 amntOfFs, pluralize(letterF,amntOfFs));



	}

	static int getNumberOfStudents(){
		int numberOfStudents = 0;
		System.out.print("Enter number of students: ");
		numberOfStudents = scanner.nextInt();
		return numberOfStudents;
	}//close getNumberOfStudents

	static void getStudentGrades(){
		double studentGrade = 0;
		for (int x = getNumberOfStudents(); x > 0; x--){
			System.out.print("Enter the students grade: ");
			studentGrade = scanner.nextDouble();
			studentGrades.add(studentGrade);
			if ( studentGrade >= 93) {
				amntOfAs++;
			} else if (studentGrade >= 85) {
				amntOfBs++;
				} else if (studentGrade >= 77){
					amntOfCs++;
					}else if(studentGrade >= 70) {
						amntOfDs++;
						} else {
							amntOfFs++;
						}
		}
	}//close getStudentGrades

	static String pluralize(String letterGrade, int amntOfLetter) {
		if (amntOfLetter > 1){
			letterGrade = letterGrade + "'s";
		} else if (amntOfLetter == 0) {
			letterGrade = letterGrade + "'s";
		}
		return letterGrade;
	}//close pluarlize


}//close class