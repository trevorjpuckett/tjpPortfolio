
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class C3ProgrammingEx {

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	static String intialInput =  "java is the best programming language!";


	public static void main(String args[]){
		List<String> mReplacerWords = new ArrayList<>();
			mReplacerWords.add("greatest");
			mReplacerWords.add("replace");
			mReplacerWords.add("replaced");
		System.out.println("Okay, I will capitalize all of the words in any given sentence you enter. (Ill also give you some \"fun facts\"!)"
							+ " I'll choose a sentence, and then you'll enter a sentence and I'll capitalize it to!");
		System.out.printf("I'm going to capitalize the words in \"%s\" Ready? here we go: %n%n", intialInput);
			capitalize(intialInput, mReplacerWords);
		System.out.println("Okay, now it's your turn!");
			run(mReplacerWords);

	}

	static void capitalize(String string, List<String> replacerWords) {
		List<String> words = new ArrayList<>(Arrays.asList(string.split("\\s+")));
		String capitalizedString = "";
		int index = 0;
		System.out.printf("The length of your entered sentence is: %d characters total! wow! %n", string.length());
		System.out.printf("THIS IS WHAT IT LOOKS LIKE IN ALL UPPERCASE:  %s %n%n", string.toUpperCase());
		System.out.println("Now lets go through each word you have entered individually: ");
			for (String word : words) {
				String firstLetter = word.substring(0,1).toUpperCase();
				String remainder = word.substring(1).toLowerCase();
				String capitalized = firstLetter + remainder;
				if (index == 0) {
					System.out.println("You have entered: ");
				}else {
					System.out.println("followed by: ");
				 }
				 System.out.println(capitalized);
				capitalizedString = capitalizedString + capitalized + " ";
				index++;
			}
			System.out.printf("All of these words together is: " + capitalizedString + "%n%n");
			System.out.println("I'm gonna randomly replace one word you entered with a different word. Ready? here it goes: ");
			words.set(random.nextInt(words.size()), replacerWords.get(random.nextInt(replacerWords.size())));
			capitalizedString = "";
						for (String word : words) {
							String firstLetter = word.substring(0,1).toUpperCase();
							String remainder = word.substring(1).toLowerCase();
							String capitalized = firstLetter + remainder;
							capitalizedString = capitalizedString + capitalized + " ";
						}
			System.out.printf(capitalizedString + "%n%n");
			System.out.println("Let's loop through those words you entered again... "
								+ "Except this time I am going to remove punctutation");
					capitalizedString = "";
					index = 0;
					for (String word : words) {
						String firstLetter = word.substring(0,1).toUpperCase();
						String remainder = word.substring(1).toLowerCase().trim().replace("!", " ").replace(",", " ").replace(".", " ").replace("?", " ");
						String capitalized = firstLetter + remainder;
						if (index == 0) {
							System.out.println("You have entered: ");
						}else {
							System.out.println("followed by: ");
						 }
						System.out.println(capitalized);
						capitalizedString = capitalizedString + capitalized + " ";
						index++;
				}
				System.out.printf("All of these words together (with no punctuation) is: " + capitalizedString + "%n%n");
	}


	static void run(List<String> replacerWords) {
		String userSentence = "";
		System.out.println("Please enter a sentence for me to capitalize, be as tricky as you would like. ;)");
		userSentence = scanner.nextLine().trim();
		capitalize(userSentence, replacerWords);
	}

}