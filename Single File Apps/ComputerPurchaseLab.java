/* Trevor J Puckett
	10/10/2018      */

//list import(s)
import java.util.Scanner;


public class ComputerPurchaseLab {

		// declarations
		static final double DISCOUNT_START_PRICE = 500.00;
		static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]){

		returnPrice(promptUserInput());

	}

	//prompt input
	public static double promptUserInput(){
		String mName;
		double purchasePrice;
		System.out.print("Welcome user, please enter your name: ");
		mName = scanner.next();
		System.out.printf("Glad to see you %s. %n what is the price of the computer you wish to purchase? ", mName);
		purchasePrice = scanner.nextDouble();
		return purchasePrice;
	}
	//apply discount
	public static void returnPrice(double purchPrice){
		System.out.printf("You have entered: $%,.2f %n",purchPrice);
			if(purchPrice>=500){
				purchPrice = purchPrice - 35.00;
			}
		System.out.printf("The current cost of the computer is: $%,.2f %n%n", purchPrice);
	}


}