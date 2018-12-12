import java.util.Scanner;

public class TestNumberCast {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("Enter an integer:  ");
		int num = scanner.nextInt();
		int sum = 0;
		String strNum = "" + num;
		for(char number : strNum.toCharArray()){
			System.out.printf(number + " ");
			String strNumber = "" + number;
			sum += Integer.parseInt(strNumber);
		}
		System.out.printf("%n%nThe sum of all of those numbers is: %d %n", sum);
			int x = strNum.length();
			char[] numbers = strNum.toCharArray();
			while(x>0){
				System.out.print(numbers[x-1]);
				x--;
			}
			System.out.println();
	}


}