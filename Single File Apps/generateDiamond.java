/* Trevor J Puckett
		11/12/2018	*/

/********************************* PROMPT ******************************************************************************
	Write a program to input a number of asterisks to print and a number to put on each line,
	then print out the asterisks as requested.  Go to the next line after all asterisks have been printed.
	Hint: Whenever the loop counter is divisible by the number to put on a line, go to the next line.
	Divisible or not, print the asterisk and stay on the same line.
						Sample run:
						How many asterisks? 49
						How many per line? 7

						*******
						*******
						*******
						*******
						*******
						*******
						*******
	Add comments with your name, the date and a description of the program,
	put the .java file in a .zip file, and upload the .zip file to this dropbox.
********************************** END OF PROMPT *********************************************************************************/


import java.util.Scanner;

public class generateDiamond{

	static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){
			run();

    }//close main

    static int promptNumberOfRows(){
		System.out.println("How many rows would you like your diamond to have?");
		int numberOfRows = getInteger();
	return numberOfRows;
	}//close promptNumberOfRows

	static int getInteger(){
		String sResult = "";
		int result = 0;
		boolean isInteger = false;
		System.out.print("Enter a number:  ");
		do {
			sResult = scanner.next();
			try {
				result = Integer.parseInt(sResult);
				isInteger = true;
			}catch(NumberFormatException nfe){
				System.out.println("Oooops, that doesnt seem to be a number...");
				System.out.println("Try again!");
			}
		}while(!isInteger);
	return result;
	}//close getInteger

	static void generateDiamond(int numberOfRows){
		int x,i, space;
		space = numberOfRows - 1;
        for (x = 0; x < numberOfRows; x++ ){
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= x; i++){
                System.out.printf("*$");
            }
            System.out.printf("*"); // break
        }
        space = 1;
      for (x = 1; x <= numberOfRows - 1; x++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= numberOfRows - x - 1; i++)
            {
                System.out.print("*$");
            }
            System.out.println("*");
        }
	}//close generateDiamond

	static void run(){
		boolean timeToQuit = false;
		do {
			System.out.println("Would you like to generate a diamond?  ( yes / no )");
			String choice = scanner.next();
			switch(choice) {
				case "yes":
					generateDiamond(promptNumberOfRows());
					break;
					case "no":
					timeToQuit = true;
					break;
					default:
						System.out.println("I don't know what that was.. Please try again.");
						break;
			}

		}while(!timeToQuit);
	}//close run
}//close class