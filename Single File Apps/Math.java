

public class Math {


	public static void main(String args[]){

		double answer = 0;
		int iAnswer = 0;

		answer = 20 - 12 / 4 * 2;
		iAnswer = 20 - 12 / 4 * 2;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		answer = 32 % 7;
		iAnswer = 32 % 7 ;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		answer = 3 - 5 % 7;
		iAnswer = 3 - 5 % 7 ;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		answer = 18.0 / 4;
		iAnswer =  0;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		answer = 28 - 5/2.0;
		iAnswer =  0;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);


		answer = 17 + 5 % 2 - 2;
		iAnswer =  17 + 5 % 2 - 2;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		answer = 15.0 + 3.0 * 2.0 / 5.0;
		iAnswer =  0;

		System.out.printf("double: %.2f , int: %d %n" ,answer, iAnswer);

		double x, y;
		int num1, num2, newNum;
		x = 1.5654894;
		y = 2;
		num1 = 0;
		num2 = 0;
		newNum = 0;


		System.out.printf("%.2f %.2f %.2f",x, y, (x+12/y-18));

		num1 = (int) Math.round(x);


	}

}
