 /* Trevor J Puckett
 		11/28/2018	*/


 import java.util.Scanner;

public class LetterDiamond {

	static Scanner scanner = new Scanner(System.in);
	static String sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static char[] alphabet;

	public static void main(String[] agrs){
		run();
	}//close main

	static void run(){
		alphabet = loadAlphabet(sAlphabet);
		boolean timeToQuit = false;
		String choice = "";
		do {
			System.out.println("Would you like to generate another letter diamond? ( yes / no )");
			choice = scanner.next();
			switch(choice){
				case "yes":
					generateDiamond();
					break;
				case "no":
					timeToQuit = true;
					break;
				default:
					System.out.printf("I have no idea what you entered... Okay i lied.. You typed \"%s\".%n"
										+"I was looking for yes or no.. Try again!%n", choice);
					break;
			}
		}while(!timeToQuit);
	}

		static char[] loadAlphabet(String sAlphabet){
			char [] mpAlphabet = sAlphabet.toCharArray();
			return mpAlphabet;
		}

		static int promptLetter(){
			int index = 0;
			System.out.print("Enter a letter:  ");
			char letter = scanner.next().toUpperCase().charAt(0);
			index = sAlphabet.indexOf(letter) + 1;
			return index;
		}

		static int getIndex(double counter, double rowLength){
			int index = 0;
			if (((counter/rowLength) > .5)){
			    index = (int)rowLength - (int)counter;
			} else {
				index = (int)counter - 1;
			}
			return index;
		}

		static void generateDiamond(){
        int i, j, letter, space;
        letter = promptLetter();
        space = letter - 1;
        for (j = 1; j <= letter; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2*j-1; i++)
            {
                System.out.printf("%c", alphabet[getIndex(i,(2*j-1))]);

            }
            System.out.println("");
        }
        space = 1;
        for (j = 1; j <= letter - 1; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (letter - j) - 1; i++)
            {
                System.out.printf("%c", alphabet[getIndex(i,(2*(letter-j)-1))]);
            }
            System.out.println("");
        }
	}//close generateDiamond

}//close class