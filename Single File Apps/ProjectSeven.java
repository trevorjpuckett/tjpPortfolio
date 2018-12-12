import java.util.Scanner;

public class ProjectSeven {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		run();


	}

	static void run(){
		int number = promptInput();
		for(int x = 0; x < number; x++){
			System.out.println("*");
		}
	}

	static int promptInput(){
		System.out.print("Please enter an integer:  ");
		int input = scanner.nextInt();
	return input;
	}//close promptInput

}