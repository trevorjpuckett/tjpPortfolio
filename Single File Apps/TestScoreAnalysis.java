/* state all your necessary imports
	for this program will will be using scanner & list*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Create your class
public class TestScoreAnalysis {

	//Create & instantiate a new scanner.
	public static Scanner scanner = new Scanner(System.in);


	/* State all variables you will be using in this program.
		go ahead and initialize any variables that will be final.
		Keep in mind, the client is only looking for 6 different test scores to be entered at a time. */
	public static final int NO_OF_STUDENTS = 6;
	public static double testOne;
	public static double testTwo;
	public static double testThree;
	public static double testFour;
	public static double testFive;
	public static double testSix;
	public static double scoreSum;


	//create list for doubles storing these in list will be useful :)
	public static List<Double> testScores;

	//Create your main method
	public static void main(String args[]){

		// initialize your non-final variables
		testOne = 0;
		testTwo = 0;
		testThree = 0;
		testFour = 0;
		testFive = 0;
		testSix = 0;
		scoreSum = 0;


		//initialize list for doubles
		testScores = new ArrayList<Double>();

		// Call welcome method to establish user interface
			welcome();

		// Call setScores method to store the user-input test scores and verify what they have entered.
			setScores();

		// Call calcSum method to calculate the sum of all entered test scores and print the results
			scoreSum = calcSum(testScores);

		// Call calcAvg method to calculate the average and print the results
			calcAvg(scoreSum, NO_OF_STUDENTS);

	}

	//Method to welcome users and establish user controls
	public static void welcome() {
				System.out.println("Welcome to the Test score analyizer! This verison will only analyze exactly 6 test scores at a time. ");
				System.out.println("Rules of entry: enter six consecutive test scores, press the enter key after each score is .. erhm.. entered. ");
				System.out.println("You may enter as many decimal places as you wish, during verification process it will be rounded to 2 deciamls, ");
				System.out.println("but during calculations it will not round your decimals.");
				System.out.println("Please enter your test scores now: ");
	}

	//Method for user to set test scores & store them in the testScores List
	public static void setScores() {
			testOne = scanner.nextDouble();
			testScores.add(testOne);
		System.out.printf("To verify, you entered: %.2f %n", testOne);
			testTwo = scanner.nextDouble();
			testScores.add(testTwo);
		System.out.printf("To verify, you entered: %.2f %n", testTwo);
			testThree = scanner.nextDouble();
			testScores.add(testThree);
		System.out.printf("To verify, you entered: %.2f %n", testThree);
			testFour= scanner.nextDouble();
			testScores.add(testFour);
		System.out.printf("To verify, you entered: %.2f %n", testFour);
			testFive= scanner.nextDouble();
			testScores.add(testFive);
		System.out.printf("To verify, you entered: %.2f %n", testFive);
			testSix= scanner.nextDouble();
			testScores.add(testSix);
		System.out.printf("To verify, you entered: %.2f %n %n", testSix);
	}

	//Method to calculate the sum of all the test scores
	public static double calcSum(List<Double> testScores) {
		double sum = 0;
		for (double testScore : testScores) {
			sum = sum + testScore;
		}
		System.out.printf("The sum of all test scores entered is :  %.2f %n%n", sum);
		return sum;
	}

	// Method to calculate the average of all test scores
	public static void calcAvg(double scoreSum, int students) {
		double avg = scoreSum / students;
		System.out.printf("The average of the scores you entered is :  %.2f %n%n", avg);
	}

}