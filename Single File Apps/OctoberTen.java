import java.util.Scanner;

public class OctoberTen {


	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]){

	int userResponse;

	System.out.print("Please enter a number: ");
	userResponse = scanner.nextInt();

		if(userResponse == 0){
			System.out.println("Thats a Zero.");
		} else if(userResponse < 0){
			System.out.println("Yup, that's negative..");
			} else {
				System.out.println("Dayyum, that's positive SON!");
			   }

	}

}