/* Trevor J Puckett */




/************************************** NOTES *****************************************************************

	ALL CODE HEREIN HAS BEEN WRITTEN BY TREVOR J PUCKETT
	(WITHOUT THE AID OF AN IDE)

************************************ END OF NOTES *******************************************************************/

//sum numbers while its less than a 1000
//get 5 numbers and sum all the even numbers
// enter a number convert it to string, seperate it into single numbers and sum it
// add while loop to print the numbers backwards

/******************* IMPORTS *****************************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class FeelingLoopy {

/******************** FINALS & UTILITIES ************************************************************************************/
	static Scanner scanner = new Scanner(System.in);
	static Random rnd = new Random();
	//static Map<String,String> mainMenuOptions
	static Map<String,String> menuOptions = new TreeMap<>();
	static Map<String,String> otherMenuOptions = new TreeMap<>();
	static final double MAX_SUM = 1000;
	static final int MAX_TRIES = 5;
	static final int MAX_MISSES = 7;
	// static final int MAX_SCORE = 21;  **** No longer in use


/***************** MAIN METHOD *************************************************************************************/
	public static void main(String args[]){
		//runProject(menuOptions);
		runOtherStuff(otherMenuOptions, MAX_SUM, MAX_TRIES, MAX_MISSES);
	}//close main


/***************************RUN METHOD****************************************************************/

	static void runProject(Map<String,String> menu){
		createMainMenu(menu);
		optionMenu(menu);
	}//close runProject

	 static void runOtherStuff(Map<String,String> menu, double max_sum, int max_tries, int max_misses){
		clearMenu();
		createMenu(menu);
		boolean timeToQuit = false;
		String choice = "";
		do{
			optionMenu(menu);
			System.out.println("Which game would you like to play?");
			choice = scanner.next().toLowerCase().trim();
			switch(choice){
				case "five":
					fiveNumbers(max_tries);
					break;
				case "addup":
					addUp(max_sum);
					break;
				case "poolvolume":
					runPoolVolume();
					break;
				case "hangman":
					hangman(max_misses);
					break;
				case "blackjack":
					runBlackJack();
					break;
				case "bodyfatcalc":
					bodyFatCalc();
					break;
				case "lsrps":
					lsrps();
					break;
				case "arrayloop":
					runArrayLoop();
					break;
				case "diamond":
					runGenerateDiamond();
					break;
				case "letterdiamond":
						runGenerateLetterDiamond();
						break;
				case "quit":
					System.out.println("oh.. okay. I understand. See you next time!");
					timeToQuit = true;
					break;
				default:
					System.out.println("I'm gonna pretend you didn't enter that... Try again!");
				break;
			}
		}while(!timeToQuit);
	}//close run

/***********************MENU SETUP*********************************************************************************/
	static void createMainMenu(Map<String,String> menu){
		menu.put("FinalProject","Run the final project you assigned us.");
		menu.put("OtherStuff","Run some other things I've added to this project =]");

	}//close createMainMenu

	static void createMenu(Map<String,String> menu){
			menu.put("AddUp","Add up numbers to equal 1,000, but don't go over!");
			menu.put("BlackJack","Play a game of Black Jack!");
			menu.put("Five","You enter five numbers and we'll see an outcome. =]");
			menu.put("Hangman","Play a game of hangman?");
			/*TODO: tjp Add in commented out loops. */
			menu.put("ArrayLoop","Does some fun array stuff. Give it a shot!");
			menu.put("BodyFatCalc","Calculate body fat with given dimensions");
			menu.put("LSRPS","Play a game of Rock, Paper, Scissor, Lizard, Spock.");
			menu.put("Diamond","Decide how big you want it.. and generate a beautiful diamond!");
			menu.put("LetterDiamond","Enter a letter and generate an alphabetical diamond with your letter in the center!");
			menu.put("PoolVolume","Calculate pool volume with given dimensions.");
			menu.put("Quit", "quit the program because you aren't having fun with these loops anymore..");
	}//close createMenu
	static void optionMenu(Map<String,String> menu){
		System.out.printf("Your options are: %n%n");
		for(Map.Entry<String, String> option : menu.entrySet()){
			System.out.println(option.getKey() + ", " + option.getValue());
		}
		System.out.println();
	}//close optionMenu

	static void clearMenu(){
		for(Map.Entry<String, String> option : menuOptions.entrySet()){
			menuOptions.remove(option.getKey(),option.getValue());
		}
		//menuOptions.removeAll(tempMenu);
		//System.out.println("Everything has been removed..");
	}//close clearDeck

/****************************************** ESSENTIAL GETTERS ******************************************************/
 	 static double getDouble(){
 		 String sResponse = "";
 		 double response = 0;
 		 boolean isDouble = false;
 		 do {
 			 sResponse = scanner.next().trim();
 			 try{
 				response = Double.parseDouble(sResponse);
 				isDouble = true;
 			 }catch(NumberFormatException nfe){
 				 System.out.println(sResponse + " doesn't seem to be a number..");
 				 System.out.println("Please try again:");
 			 }
 		 }while(!isDouble);
 	 return response;
 	 }//close getDouble

	static int getInteger(){
		 String sResponse = "";
		 int response = 0;
		 boolean isInteger = false;
		 do {
			 sResponse = scanner.next().trim();
			 try{
				response = Integer.parseInt(sResponse);
				isInteger = true;
			 }catch(NumberFormatException nfe){
				 System.out.println(sResponse + " doesn't seem to be a number..");
				 System.out.println("Please try again:");
			 }
		 }while(!isInteger);
	 return response;
	 }//close getInteger

/************************************ END OF ESSENTIAL GETTERS ******************************************************/



/***********************ADDUP [SUM NUMBERS]*********************************************************************/
	public static void addUp(double max_sum){
		int sum = 0;
		System.out.printf("Okay, we are going to add up some numbers.."
						 + " There is but one rule..%n"
						 + "Do not, I repeat DO NOT go over %,.2f %n%n", max_sum);
		do {
			System.out.printf("Please enter a number a number"
							   + " to add to your current sum.%n");
				double num = getDouble();
				sum+=num;
		}while(sum < max_sum);
		if(sum == max_sum){
			System.out.printf("Congrats! you got it exactly to %,.2f %n%n"
							   +"************************************************************************************** %n%n"
								, max_sum);
		} else {
		System.out.printf("Whelp... you did it. You went over %,.2f "
							+"by %,.2f ... and lost the game. Maybe try a new game!%n%n"
							+"************************************************************************************** %n%n"
							,max_sum,(sum-max_sum));
			}
	}//close breaker
/********************************* END OF ADD UP *******************************************************************************/

/**********************FIVE NUMBERS GAME [ADD UP ODD & EVEN]********************************************************************/
	public static void fiveNumbers(int amountOfTries){
		List<Integer> evenNumbersToAdd = new ArrayList<>();
		List<Integer> oddNumbersToAdd = new ArrayList<>();
		int evenSum = 0;
		int oddSum = 0;
		String evenNumbers = "";
		String oddNumbers = "";
		System.out.printf("Okay, so you enter %d numbers between 1 and 10%n",amountOfTries);
		for(int x = 0; x < amountOfTries; x++){
			int num = 0;
			do {
				System.out.print("Enter a number: ");
				num = scanner.nextInt();
				if(num>10 || num<1){
					System.out.println("That is not between 1 and 10..");
					System.out.print("Please enter a new number: ");
					System.out.println();
					 num = scanner.nextInt();
				}
			}while(num>10||num<1);


			if(num%2==0){
				evenNumbers+=num + " ";
				evenNumbersToAdd.add(num);
			} else {
				oddNumbers+=num + " ";
				oddNumbersToAdd.add(num);
			}
		}

		for(int number : evenNumbersToAdd){
			evenSum+=number;
		}
		for(int number : oddNumbersToAdd){
					oddSum+=number;
		}
		System.out.printf("All even numbers you entered: %s%n"+"All odd numbers you entered: %s%n%n"
							+"The sum of the even numbers you entered is %d, pretty cool huh?%n"
							+"I also took the liberty of adding up your odd numbers... not as cool but it came out to be %d...%n%n"
							+"Try a new game %n!"
							+ "************************************************************************************************** %n%n",
								evenNumbers, oddNumbers, evenSum, oddSum);
	}//close fiveNumbers
/************************************ END OF FIVE NUMBERS **************************************************************************************************/
/************************************************ HANGMAN GAME *********************************************************************************************/
	public static void hangman(int max_misses){
		List<String> answerPool = new ArrayList<>();
		// answerPool = importAnswerPoolFrom("answerpool.txt"); /* Your computer will not have an answerpool.txt.... */
			answerPool = loadAnswerPool();
				String answer = "";
				String progress = "";
				String hits = "";
				String misses = "";
				int triesRemaining = max_misses;
				boolean isHit = false;
				boolean gameIsWon = false;
				boolean gameIsLost = false;
			answer = newAnswer(answerPool);
		do {
		displayProgress(answer,hits,misses,max_misses);
		boolean isAcceptable = false;
			do {
				isAcceptable = false;
				try {
					isAcceptable = true;
					char letter = charifyGuess(misses, hits);
					isHit = verifyGuess(letter, answer);
					if (isHit) {
						hits += letter;
					} else {
						misses += letter;
		 	    	  }
				}catch(IllegalArgumentException iae) {
			     	System.out.printf("%s %n%n", iae.getMessage());
			     }

			}while(!isAcceptable);
			progress = getCurrentProgress(answer,hits);
			triesRemaining = (max_misses- misses.length());
			if (progress.equals(answer)) {
				gameIsWon = true;
			} else if(triesRemaining == 0){
				gameIsLost = true;
			  }
		}while(!gameIsWon && !gameIsLost);
		if(gameIsWon) {
			System.out.println(answer);
			System.out.printf("Congrats! You just won hangman, in only %d guesses, and %s misses!%n%n", (misses.length()+hits.length()), misses.length());
		} else if(gameIsLost){
				System.out.printf("Tough break, you lost. The correct word was %s.%n%n", answer);
			} else {
				System.out.println("Not sure what happened...");
			  }
	System.out.printf("************************************************************************************** %n%n");


	}//close hangman


/**********************CREATE ANSWER POOL *****************************************************/

	static List<String> loadAnswerPool(){
		List<String> tempAnswerPool = new ArrayList<>();
			tempAnswerPool.add("classroom");
			tempAnswerPool.add("friendly");
			tempAnswerPool.add("words");
			tempAnswerPool.add("truck");
			tempAnswerPool.add("computer");
			tempAnswerPool.add("programming");
			tempAnswerPool.add("chipotle");
			tempAnswerPool.add("java");
			tempAnswerPool.add("bam");
			tempAnswerPool.add("lucky");
			tempAnswerPool.add("hitchhiker");
			tempAnswerPool.add("wander");
			tempAnswerPool.add("nomad");
			tempAnswerPool.add("broccoli");
			tempAnswerPool.add("loop");
			tempAnswerPool.add("moon");
			tempAnswerPool.add("stars");
			tempAnswerPool.add("bulldozer");
			tempAnswerPool.add("logarithmic");
			tempAnswerPool.add("cadence");
			tempAnswerPool.add("Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu");
		return tempAnswerPool;
	}//close loadAnswerPool

/*******************VERIFY AND NORMALIZE GUESS*************************************************/


/************VERIFY GUESS**********************/
	static boolean verifyGuess(char letter, String answer) {
		boolean isHit = answer.indexOf(letter) != -1;
	return isHit;
	}//close ApplyGuess

/*****************NORMALIZE GUESS*****************************/
	static char normalizeGuess(char letter,String misses, String hits) {
		if (! Character.isLetter(letter)) {
		    throw new IllegalArgumentException("A letter is required");
		}
		letter = Character.toLowerCase(letter);
		// see if misses or hits already contains the letter being guessed
		if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
			throw new IllegalArgumentException(letter + " has already been guessed **");
		}
	return letter;
 	}//close normalizer

/****************CHARIFY GUESS******************/
	static char charifyGuess(String misses, String hits) {
	   String letters = promptForGuess();
	   if (letters.length() == 0) {
       		throw new IllegalArgumentException("No letters found, please enter a letter.");
		}
	return normalizeGuess(letters.charAt(0), misses, hits);
	}//close charifyGuess

/**************PROMPT FOR GUESS*************************************************/
    static public String promptForGuess() {
            System.out.print("Enter a letter:   ");
            String guessInput = scanner.next();
        return guessInput;
	}//close promptForGuess

/**************DISPLAY PROGRESS*******************************************/
    static String getCurrentProgress(String answer,String hits) {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '-';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
	}//close getCurrentProgress
    static void displayProgress(String answer, String hits,String misses, int max_misses) {
		int attemptsRemaining = max_misses - misses.length();
        System.out.printf("You have %d misses left to solve:  %s%n",
        					attemptsRemaining, getCurrentProgress(answer,hits));
    }//close displayProgress

/***************PICK NEW ANSWER********************************************/
	static String newAnswer(List<String> answerPool){
		String tempAnswer;
		tempAnswer = answerPool.get(rnd.nextInt(answerPool.size()));
	return tempAnswer;
	}//close newAnswer

/**************IMPORT ANSWER POOL*********************************************
    static List<String> importAnswerPoolFrom(String filename) {
		List<String> tempAnswerPool = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
            	tempAnswerPool.add(line.trim().toLowerCase());
            }
        } catch (IOException ioe) {
            System.out.printf("Problem loading %s %n", filename);
            ioe.printStackTrace();
        }
	return tempAnswerPool;
    }//close importAnswerPool

*********************************** IMPORT ANSWER POOL IS SUPERIOR METHOD BUT UNUSED ***********************************************/

/********************************************** END OF HANGMAN ***************************************************************************************/


/********************************************* BLACK JACK *********************************************************************************************/
	static String userName = "";
	static String dealerName = "Dealer";
	static List<String> deck = new ArrayList<>();
	static List<String> userHand = new ArrayList<>();
	static List<String> dealerHand = new ArrayList<>();
	static int currentUserScore = 0;
	static int currentDealerScore = 0;
	static double userBank = 50;
	static double pot = 0;


	static void printDeckContents(){
		for(String card : deck){
			System.out.println(card);
		}

	}//close printDeckContents
/************************** PROMPTING ***************************************/
	static double promptBet(){
		double bet = 0;
		boolean acceptableBet = false;
		System.out.print("Enter the amount you would like to bet: ");
		do{
			bet = getDouble();
			if ((userBank - bet) >= 0){
				acceptableBet = true;
			} else {
				System.out.println("You do not have enough funds to place that bet.");
			}
		}while(!acceptableBet);
		return bet;
	}//close promptBet

	static String promptHit(){
		System.out.println("The choice is yours:  ( hit / stand )");
		String choice = scanner.next();
	return choice;
	}//close promptHit

	static String promptUserName(){
		boolean isValidName = false;
		System.out.print("Enter a username:  ");
		String userName = "";
		do{
			userName = scanner.next();
			if(!userName.toLowerCase().trim().equals("dealer")){
				isValidName = true;
			}else {
					System.out.println("I think we both know you are not the dealer... -.- ...");
					System.out.print("Try a different name:  ");
				}
		}while(!isValidName);
	return userName;
	}//close promptUserName

	static boolean promptAnotherRound(){
		boolean noMoreRounds = false;
		boolean validResponse = false;
		System.out.println("Would you like to play another around? ( yes / no )");
		do{
			String response = scanner.next().toLowerCase().trim();
			switch (response){
				case "yes":
					validResponse = true;
					break;
				case "no":
					noMoreRounds = true;
					validResponse = true;
					break;
				default:
					System.out.printf("%n%s is not a valid response.. Please enter yes or no.");
					break;
			}
		}while(!validResponse);
	return noMoreRounds;
	}//close promptAnotherRound

/************************* MECHANICS *************************************/
	static double placeBet(double tempPot){
		double playerBet = promptBet();
		userBank -= playerBet;
		if (getCurrentTotal(userName) < 21){
			playerBet *= 2;
		}
		tempPot += playerBet;
		return tempPot;
	}//close placeBet

	static void roundOutcome(int score1, int score2, double currentPot){
		boolean userWins = false;
		boolean userBust = determineBust(score1);
		boolean dealerBust = determineBust(score2);
		if (userBust){
			System.out.printf("Sorry, you've lost. Better luck next time! ... You'll probably win next time.%n%n");
		} else if(dealerBust && !userBust) {
			System.out.printf("Congrats! you've won! %n%n");
				userBank += currentPot;
				displayUserBank();
		} else if (score1 > score2){
			System.out.printf("Congrats! you've won! %n%n");
				userBank += pot;
				displayUserBank();
		} else if(score1 == score2){
				System.out.printf("A tie! a Tie I say! Hip hip ... horay?.. %n");
				userBank += pot/2;
			}
	}//close roundOutcome

	static boolean determineBust(int score){
		boolean bust = false;
		if(score > 21){
			bust = true;
		}
		return bust;
	}//close determineBust

	static boolean dealersChoice(){
		boolean stand = false;
		if((getCurrentTotal(dealerName) >= 17) && (getCurrentTotal(dealerName) > getCurrentTotal(userName))){
			stand = true;
		} else {
			System.out.println("Dealer hits.");
			newCard(dealerName);
		}
	return stand;
	}//close dealersChoice

	static void startingHand(String playerName){
		clearAllCards(playerName);
		newCard(playerName);
		newCard(playerName);
	}//close startingHand

	static boolean hit(String playerName ,String choice){
		boolean stand = false;
		switch(choice){
			case "hit":
				newCard(playerName);
				break;
			case "stand":
				stand = true;
				break;
			default:
				System.out.println("Not sure you know what you wanna do... ");
				break;
		}
	return stand;
	}//close hit

	static void updateTotalScoreOfHand(List<String> hand, String playerName){
		setScoreZero(playerName);
		for (String card : hand){
			int cardValue = getCardValue(card, playerName);
			if (playerName.equals(dealerName)){
				currentDealerScore += cardValue;
			} else {
				currentUserScore += cardValue;
			}
		}
	}//close updateTotalScoreOfHand

	static void clearAllCards(String playerName){
		List<String> cardsToRemove = new ArrayList<>();
		if(playerName.equals(dealerName)){
			for(String card : dealerHand){
				cardsToRemove.add(card);
			}
			dealerHand.removeAll(cardsToRemove);
		} else {
			for(String card : userHand){
				cardsToRemove.add(card);
			}
			userHand.removeAll(cardsToRemove);
		  }
	}//close clearAllCards
	static void setScoreZero(String playerName){
		if(playerName.equals(dealerName)){
			currentDealerScore = 0;
		} else {
			currentUserScore = 0;
		}
	}//close setScoreZero
	static int getCurrentTotal(String playerName){
		int currentTotal = 0;
		if(playerName.equals(dealerName)){
			currentTotal = currentDealerScore;
		} else {
			currentTotal = currentUserScore;
			}
	return currentTotal;
	}//close getCurrentTotal

	static int getCardValue(String card, String playerName){
		int cardValue = 0;
		if(Character.isLetter(card.charAt(0))){
			switch(card){
				case "a":
				if(getCurrentTotal(playerName) > 21){
						cardValue = 1;
				} else {
						cardValue = 11;
					}
					break;
				default:
					cardValue = 10;
					break;
			}
		}else{
			cardValue = Integer.parseInt(card);
		 }
		return cardValue;
	}//close getCardValue


	static void newCard(String playerName){
		int newCard = rnd.nextInt(deck.size());
		if(playerName.equals(dealerName)){
			dealerHand.add(deck.get(newCard));
			deck.remove(newCard);
		}else {
			userHand.add(deck.get(newCard));
			deck.remove(newCard);
		}

	}//close newCard()

	static void clearDeck(){
		List<String> cardsRemaining = new ArrayList<>();
		for(String card : deck){
			cardsRemaining.add(card);
		}
		deck.removeAll(cardsRemaining);
		//System.out.println("Everything has been removed..");
	}//close clearDeck

	static void shuffleDeck(){
		clearDeck();
		List<String> tempDeck = new ArrayList<>();
		List<String> cardTypes = new ArrayList<>();
			cardTypes.add("a a a a");
			cardTypes.add("j j j j");
			cardTypes.add("k k k k");
			cardTypes.add("q q q q");
			cardTypes.add("2 2 2 2");
			cardTypes.add("3 3 3 3");
			cardTypes.add("4 4 4 4");
			cardTypes.add("5 5 5 5");
			cardTypes.add("6 6 6 6");
			cardTypes.add("7 7 7 7");
			cardTypes.add("8 8 8 8");
			cardTypes.add("9 9 9 9");
			cardTypes.add("10 10 10 10");
		for(String cardType : cardTypes){
			String[] cards = cardType.split("\\s+");
			for (String card : cards) {
				tempDeck.add(card);
			}
		}
	 deck.addAll(tempDeck);
	}//close shuffleDeck
/*************************** DISPLAY ********************************/
	static void displayCurrentHand(List<String> hand, String playerName,String status){
		String currentHand = "";
		for (String card : hand){
			currentHand += card + "(" + getCardValue(card, playerName) + ") ";
		}
		System.out.printf("%s's %s hand: %s, which totals to %d%n",playerName,status,currentHand,getCurrentTotal(playerName));
	}//close displayCurrentHand

	static void displayUserBank(){
		System.out.printf("Bank:  %.2f%n"
							+"____________________%n%n", userBank);
	}//close displayUserBank

	static void displayCurrentPot(double currentPot){
		System.out.printf("Current pot:   %.2f%n"
							+"____________________%n%n", currentPot);
	}//close displayCurrentPot


/******************* RUN **********************************************/

	static boolean blackJackRound(){
		boolean mNoMoreRounds = false;
		boolean userStand = false;
		boolean dealerStand = false;
		boolean userBust = false;
		do{
			String status = "current";
			pot = 0;
			//userName = promptUserName();
			shuffleDeck();
			startingHand(dealerName);
			startingHand(userName);

			do {
				displayUserBank();
				displayCurrentPot(pot);
				updateTotalScoreOfHand(dealerHand, dealerName);
					displayCurrentHand(dealerHand, dealerName, status);
				updateTotalScoreOfHand(userHand, userName);
					displayCurrentHand(userHand, userName, status);
					pot = placeBet(pot);
				userStand = hit(userName,promptHit());
				updateTotalScoreOfHand(userHand, userName);
				userBust = determineBust(getCurrentTotal(userName));
				dealerStand = dealersChoice();
				updateTotalScoreOfHand(dealerHand,dealerName);
			}while(!userStand && !userBust);
			status = "final";
					displayCurrentHand(dealerHand, dealerName, status);
					displayCurrentHand(userHand, userName, status);
			roundOutcome(getCurrentTotal(userName),getCurrentTotal(dealerName), pot);
			mNoMoreRounds = promptAnotherRound();
		}while(!mNoMoreRounds);
	return mNoMoreRounds;
	}//close blackJackRound

	static void runBlackJack(){
		boolean userBroke = false;
		boolean bjTimeToQuit = false;
		userName = promptUserName();
		do {
			bjTimeToQuit = blackJackRound();
			if (userBank == 0){
				userBroke = true;
			}
		}while(!userBroke && !bjTimeToQuit);
		System.out.printf("Thanks for playing! you ended the game with $%.2f in your bank!%n"
						  + "**************************************************************** %n%n", userBank);

	}//close runBlackJack

/********************************* END OF BLACK JACK *****************************************************/


 /****************************** BODY FAT CALC ************************************************************/

 	static boolean timeToQuit = false;

 		static double bodyWeight = 0;
 		static double B = 0;

 		static double waistMeas = 0;
 		static double wristMeas = 0;
 		static double hipMeas = 0;
 		static double forearmMeas = 0;

 		static double bodyFat = 0;
 		static double bodyFatPercentage = 0;


 		static void bodyFatCalc(){
 			do{
 				switch(promptGender().trim().toLowerCase()){
 					case "male":
 						promptUnknowns("male");
 					break;
 					case "female":
 						promptUnknowns("female");
 					break;
 					case "quit":
 						timeToQuit = true;
 					break;
 					default:
 						System.out.println("Unknown entry, please try again!");
 					break;

 				}
 			}while(!timeToQuit);

 		}// close bodyFatCalc

 	 static String promptGender(){
 		 System.out.println("To calculate your body fat");
 		 System.out.println("please enter your gender as follows: Male / Female");
 		 System.out.printf("Or, enter quit if you would like to quit.%n");
 		 String gender = scanner.next();
 	 return gender;
 	 }//close promptGender

 	 static void promptUnknowns(String gender){
 		 if (gender.equals("male")){
 			 System.out.printf("%n%n Enter your body weight in pounds:   ");
 			 	bodyWeight = getDouble();
 			 System.out.printf("%n Enter your waist measurment:  ");
 			 	waistMeas = getDouble();
 			 System.out.printf("%nThank You%n*************************************************************** ");
 			 calcBodyFat(gender);
 		 } else {
 			 System.out.printf("%n%n Enter your body weight:  ");
 			 	bodyWeight = getDouble();
 			 System.out.printf("%n Enter your waist measurment:  ");
 			 	waistMeas = getDouble();
 			 System.out.printf("%n Enter your wrist measurment:  ");
 			 	wristMeas = getDouble();
 			 System.out.printf("%n Enter your hip measurment:  ");
 			 	hipMeas = getDouble();
 			 System.out.printf("%n Enter your forearm measurment:  ");
 			 	forearmMeas = getDouble();
 			System.out.printf("%nThank You%n*************************************************************** ");
 			calcBodyFat(gender);
 			}
 	 }//close promptUnkowns



 	 static void calcBodyFat(String gender){
 		 double a1Mult = 0;
 		 double a1Additive = 0;
 		 double a2Mult = 0;

 		 double a3Divider = 3.149;
 		 double a4Mult = 0.249;
 		 double a5Mult = 0.434;

 		 double a1 = 0;
 		 double a2 = 0;

 		 double a3 = 0;
 		 double a4 = 0;
 		 double a5 = 0;

 		 if (gender.equals("male")){
 			 a1Mult = 1.082;
 			 a1Additive = 94.42;
 			 a2Mult = 4.15;

 			 a1 = (bodyWeight * a1Mult) + a1Additive;
 			 a2 = waistMeas * a2Mult;
 			 B = a1 - a2;
 			 calcFat(bodyWeight,B);
 		 } else {
 			 a1Mult = 0.732;
 			 a1Additive = 8.987;
 			 a2Mult = 0.157;

 			 a1 = (bodyWeight * a1Mult) + a1Additive;
 			 a2 = waistMeas * a2Mult;
 			 a3 = wristMeas / a3Divider;
 			 a4 = hipMeas * a4Mult;
 			 a5 = forearmMeas * a5Mult;
 			 B = a1 + a2 - a3 - a4 + a5;
 			 calcFat(bodyWeight,B);

 		 }

 	 }//close calcBodyFat

 	 static void calcFat(double bodyweight, double b){
 		 bodyFat = bodyweight - b;
 		 bodyFatPercentage = (bodyFat/bodyWeight)*100;
 		 System.out.printf("%nYour body fat percentage:  %.2f%% %n%n", bodyFatPercentage);
	 }//close calcFat
/******************************************* END OF BODY FAT CALC ******************************************************************************/

/*********************************************** ROCK PAPER SCISSORS LIZARD SPOCK *************************************************************/
	static Map<String,String> rpsMenu = new TreeMap<>();
	static List<String> computerAnswerPool = new ArrayList<>();

		static String player1Name = "";
		static String player2Name = "";

		static int player1Score = 0;
		static int player2Score = 0;

		static String roundResult = "";

	static void lsrps(){
		System.out.printf("RULES OF THE GAME: %n"
						  + "Scissors cuts paper, paper covers rock, rock crushes lizard,%n"
						  +"lizard poisons Spock, Spock smashes scissors, scissors decapitates lizard,%n"
						  +"lizard eats paper, paper disproves Spock, Spock vaporizes rock,%n"
						  +"and as it always has, rock crushes scissors.%n"
						  +"***********************************************************************************%n%n");
		runLsrps();
	}//close lsrps
/***************************** PROMPTING *************************************************************************************/
    static String promptGameType(){
        String type;
            System.out.println("Type one of the following acronyms to play the game type: ");
            for (Map.Entry<String,String> gameType : rpsMenu.entrySet()){
                    System.out.printf("%s, %s %n",
                                      gameType.getKey(),gameType.getValue());
            }
            System.out.print("What would you like to do? ");
            type = scanner.next();
        return type.toLowerCase().trim();
    }//close promptGameType;

    static int promptNumberOfRounds(String gameTypeAdd){
		int numberOfRounds = 0;
        System.out.printf("Please enter the number of rounds you'd like to %s",gameTypeAdd);
        numberOfRounds = getInteger();
        return numberOfRounds;
    }//close promptNumberOfRounds

   static String promptPlayerName(){
        String displayName;
        System.out.print("Choose your display name:  ");
        displayName = scanner.next().trim();
        return displayName;
    }//close promptPlayerName

   static String promptForAnswer(){
        System.out.println("Choose wisely!");
        System.out.println("Rock, Paper, Scissors, Lizard, or Spock?");
        String answer =  getAnswer();
        return answer;
   }//close promptForAnswer




 /************************** SET UP ********************************************************************************************/
	static List<String> constructCompResponse(){
       List<String> mComputerAnswerPool = new ArrayList<>();
       mComputerAnswerPool = new ArrayList<>();
            mComputerAnswerPool.add("rock");
            mComputerAnswerPool.add("paper");
            mComputerAnswerPool.add("scissors");
            mComputerAnswerPool.add("lizard");
            mComputerAnswerPool.add("spock");
      return mComputerAnswerPool;
	}//close constructCompResponse

	static Map<String,String> consctructRpsMenu(){
		Map<String,String> tempMenu = new TreeMap<>();
            tempMenu.put("PvP","Player versus Player");
            tempMenu.put("PvC","Player versus Computer");
            tempMenu.put("CvC","Computer versus Computer");
            tempMenu.put("Quit","Quit the game.");
	return tempMenu;
	}//close constructRpsMenu


    static String getAnswer(){
        String verifiedAnswer;
        boolean isVerified = false;
            do {
                verifiedAnswer = scanner.next().trim().toLowerCase();
                    switch(verifiedAnswer){
                        case "rock":
                            isVerified = true;
                            break;
                        case "paper":
                            isVerified = true;
                            break;
                        case "scissors":
                            isVerified = true;
                            break;
                        case "lizard":
                            isVerified = true;
                            break;
                        case "spock":
                            isVerified = true;
                            break;
                        default :
                            System.out.println("Ooops! that doesn't seem to be one of the options! ");
                            System.out.println("Please enter one of the following:");
                            System.out.println("Rock, Paper, Scissors, Lizard, or Spcok.");
                            break;
                    }
            }while(!isVerified);
        return verifiedAnswer;
    }//close getAnswer

/*************************************************** MECHANICS *********************************************************************/
    static void overAllWinner(){
		System.out.println("*************** GAME OUTCOME *******************");
        if(player1Score > player2Score) {
            System.out.printf(player1Name + " is the winner!!%n%n");
        } else {
            System.out.printf(player2Name + " is the winner!!%n%n");
        }
    }//close OverAllWinner

    static void rewardWinner(String roundOutcome){
        if(roundOutcome.equals(player1Name + " wins!")){
            player1Score += 1;
        }else if(roundOutcome.equals(player2Name + " wins!")){
           player2Score += 1;
        }
    }//close rewardWinner

    static void roundStatus(String answer1, String answer2){
		System.out.println("*********************** ROUND OUTCOME **********************");
        System.out.printf("%n%n%s threw %s, and  %s threw %s %n",
                          player1Name,answer1,
                          player2Name, answer2);
        System.out.printf(declareWinner(answer1,answer2) + "%n%n");
            rewardWinner(declareWinner(answer1,answer2));

    }//close roundStatus

    static void displayCurrentScore(){

        System.out.printf("Current Scores: %n"
                        + "%s: %d   || %s: %d %n%n"
                        + "******************************%n",
                player1Name, player1Score,
                player2Name, player2Score);
    }//close displayCurrentScore

    static String declareWinner(String answer1, String answer2){
        String outcome;
        boolean player1Wins = false;
        boolean draw = false;
        switch (answer1){
            case "rock":
                if (answer2.equals("scissors") || answer2.equals("lizard")){
                    player1Wins =  true;
                } else if(answer2.equals(answer1)){
                    draw = true;
                }
            break;
            case "scissors":
                if (answer2.equals("paper") || answer2.equals("lizard")){
                    player1Wins = true;
                }else if(answer2.equals(answer1)){
                    draw = true;
                }
            break;
            case "paper":
                if (answer2.equals("rock") || answer2.equals("spock")){
                    player1Wins = true;
                }else if(answer2.equals(answer1)){
                    draw = true;
                }
             break;
            case "lizard":
                if(answer2.equals("paper") || answer2.equals("spock")){
                    player1Wins = true;
                }else if(answer2.equals(answer1)){
                    draw = true;
                }
             break;
            case "spock":
                if(answer2.equals("rock") || answer2.equals("scissors")){
                    player1Wins = true;
                }else if(answer2.equals(answer1)){
                    draw = true;
                }
            break;
            default:
                System.out.println("I dont understand these answers...");
             break;
        }
        if(player1Wins){
            outcome = player1Name + " wins!";
        } else if(draw){
            outcome = "It's a draw!";
        } else {
            outcome = player2Name + " wins!";
        }
        return outcome;
    }//close declareWinner

     static void createBuffer(){
        for(int x=0; x<25; x++){
            System.out.println("************************** CREATING BUFFER ******************************");
            System.out.println("**************************** DON'T CHEAT ********************************");
        }
    }//close createBuffer

	static String computerAnswer(){
		String computerThrows = computerAnswerPool.get(rnd.nextInt(computerAnswerPool.size()));
	  return computerThrows;
    }//close computerAnswer

/******************************************************************* RUN ***************************************************************/
    static void runLsrps(){
		rpsMenu = consctructRpsMenu();
		computerAnswerPool = constructCompResponse();
        String gameType;
        boolean mTimeToQuit = false;
        do {
            gameType = promptGameType();
            boolean  gameOver = false;
            int n;
            switch (gameType){
                case "pvp":
                	player1Score = 0;
                	player2Score = 0;
                    player1Name = promptPlayerName();
                    player2Name = promptPlayerName();
                    n = promptNumberOfRounds("play against each other: ");
                    for(int x = 0; x < n; x++) {
                        System.out.printf("Rounds left: %d %n", (n-x));
                        displayCurrentScore();
                        String player1Answer = promptForAnswer();
                            createBuffer();
                        String player2Answer = promptForAnswer();
                        roundStatus(player1Answer,player2Answer);
                        if (declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }

                    }
                    displayCurrentScore();
                    overAllWinner();
                break;
                case "pvc":
                	player1Score = 0;
                	player2Score = 0;
                	player1Name = promptPlayerName();
                	player2Name = "Jay The CPU";
                   n = promptNumberOfRounds("play against the computer:  ");
                    for(int x = 0; x < n; x++){
                        System.out.printf("Rounds left: %d %n", (n-x));
                        displayCurrentScore();
                        String player1Answer = promptForAnswer();
                        String player2Answer = computerAnswer();
                        roundStatus(player1Answer,player2Answer);
                        if (declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }

                    }
                    displayCurrentScore();
                    overAllWinner();
                break;
                case "cvc":
                	player1Score = 0;
                	player2Score = 0;
					player1Name = "Jay The CPU";
					player2Name = "Not-Jay The CPU";
                    n = promptNumberOfRounds("see the computers play:  ");
                    for(int x = 0; x < n; x++){
                        System.out.printf("Rounds left: %d %n", (n-x));
                        displayCurrentScore();
                        String player1Answer = computerAnswer();
                        String player2Answer = computerAnswer();
                        roundStatus(player1Answer,player2Answer);
                        if (declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }

                    }
                    displayCurrentScore();
                    overAllWinner();
                break;
                case "quit":
                    System.out.printf("Thanks for playing!%n%n");
                    mTimeToQuit = true;
                break;
                default :
                    System.out.printf("Unknown entry.. Please try again!%n%n");
                break;
            }
        }while(!mTimeToQuit);
    }//close run

 /******************************************** END OF ROCK PAPER SCISSORS LIZARD SPOCK ********************************************************/

/*********************************************** GENERATE DIAMOND **********************************************************************/

    static int promptNumberOfRows(){
		System.out.println("How many rows would you like your diamond to have?");
		int numberOfRows = getInteger();
	return numberOfRows;
	}//close promptNumberOfRows

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
                System.out.print("*$");
            }
            System.out.println("*"); // break
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

	static void runGenerateDiamond(){
		boolean rgdTimeToQuit = false;
		do {
			System.out.println("Would you like to generate a diamond?  ( yes / no )");
			String choice = scanner.next();
			switch(choice) {
				case "yes":
					generateDiamond(promptNumberOfRows());
					break;
					case "no":
					rgdTimeToQuit = true;
					break;
					default:
						System.out.println("I don't know what that was.. Please try again.");
						break;
			}

		}while(!rgdTimeToQuit);
	}//close runGenerateDiamond
/************************************** END OF GENERATE DIAMOND *****************************************************/

/******************************* GENERATE LETTER DIAMOND ***************************************************************/
	static String sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static char[] alphabet;

	static void runGenerateLetterDiamond(){
		boolean rgdTimeToQuit = false;
		do {
			System.out.println("Would you like to generate a diamond?  ( yes / no )");
			String choice = scanner.next();
			switch(choice) {
				case "yes":
					alphabet = loadAlphabet(sAlphabet);
					generateLetterDiamond();
					break;
					case "no":
					rgdTimeToQuit = true;
					break;
					default:
						System.out.println("I don't know what that was.. Please try again.");
						break;
			}

		}while(!rgdTimeToQuit);
	}//close runGenerateLetterDiamond

		static char[] loadAlphabet(String sAlphabet){
			char [] mpAlphabet = sAlphabet.toCharArray();
			return mpAlphabet;
		}//close loadAlphabet

		static int promptLetter(){
			int index = 0;
			System.out.print("Enter a letter:  ");
			char letter = scanner.next().toUpperCase().charAt(0);
			index = sAlphabet.indexOf(letter) + 1;
			return index;
		}//close promptLetter

		static int getIndex(double counter, double rowLength){
			int index = 0;
			if (((counter/rowLength) > .5)){
			    index = (int)rowLength - (int)counter;
			} else {
				index = (int)counter - 1;
			}
			return index;
		}//close getIndex

		static void generateLetterDiamond(){
        int letter, i, x, space;
        letter = promptLetter();
        space = letter - 1;
        for (x = 1; x <= letter; x++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2*x-1; i++)
            {
                System.out.printf("%c", alphabet[getIndex(i,(2*x-1))]);

            }
            System.out.println("");
        }
        space = 1;
        for (x = 1; x <= letter - 1; x++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (letter - x) - 1; i++)
            {
                System.out.printf("%c", alphabet[getIndex(i,(2*(letter-x)-1))]);
            }
            System.out.println("");
        }
	}//close generateDiamond

/********************************* END OF GENERATE LETTER DIAMOND *************************************************************************/

/************************************* POOL VOLUME ****************************************************************************************/

	public static Map<String,String> mPoolMenu = new HashMap<>();
	public static List<String> stringsToPrint = new ArrayList<>();
	public static BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));
	public static final double GALLONSPERCUFOOT = 7.5;


	public static void createPoolMenu(){
		mPoolMenu.put("Rectangular","enter rectangular if you have a rectangular pool & want the volume.");
		mPoolMenu.put("Circular","enter circular if you have a circular pool & want the volume.");
		mPoolMenu.put("Quit","quit the pogram.");
	}//close createPoolMenu

	public static String promptAction()throws IOException{
		String choice = "";
		System.out.println("Your options are: ");
		for (Map.Entry<String,String> option : mPoolMenu.entrySet()) {
			System.out.printf("%s, %s%n",option.getKey(), option.getValue());
		}
		choice = mReader.readLine();
		System.out.printf("You entered:  %s%n%n",choice);

		return choice.toLowerCase().trim();
	}//close promptAction

	public static void rectangular()throws IOException {
			double length;
			double width;
			double depth;
			double lengthFt;
			double widthFt;
			double depthFt;
			double volumeCft;
			double volumeGal;
			System.out.println("Please enter the length (in inches) of your pool:  ");
				length = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",length);
			System.out.println("Please enter the width (in inches) of your pool:  ");
				width = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",width);
			System.out.println("Please enter the depth (in inches) of your pool:  ");
				depth = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",depth);
			lengthFt = length/12;
			widthFt = width/12;
			depthFt = depth/12;
			volumeCft = lengthFt * widthFt * depthFt;
			volumeGal = volumeCft*GALLONSPERCUFOOT;
			System.out.printf("The pool volume is : %.2f Cubic Feet.%n",volumeCft);
			System.out.printf("Thats %.2f gallons.%n%n",volumeGal);

	}//close rectangular
	public static void circular()throws IOException {
		//V=pr2h
		double diameter;
		double radius;
		double depth;
		final double pi = 3.14;
		double volume;
		System.out.println("Please enter the diameter (in inches) of your pool:  ");
				diameter = Double.parseDouble(mReader.readLine());
				radius = (diameter/12)/2;
		System.out.printf("You entered:  %.2f%n",diameter);
		System.out.println("Please enter the depth (in inches) of your pool:  ");
						depth = Double.parseDouble(mReader.readLine());
		System.out.printf("You entered:  %.2f%n",depth);
		volume = pi*(radius*radius)*(depth/12);
		System.out.printf("The pool volume is : %.2f Cubic Feet.%n",volume);
		System.out.printf("Thats %.2f gallons.%n%n",volume*GALLONSPERCUFOOT);
	}//close circular


	public static void runPoolVolume() {
		createPoolMenu();
		String choice = "";
		do {
			try {
				choice = promptAction();
				switch (choice) {
					case "rectangular":
							rectangular();
						break;
					case "circular":
							circular();
						break;
					case "quit":
						choice = "quit";
						break;
					default:
						System.out.println("Unknown entry..");
						break;
				}


			} catch(IOException ioe){
					System.out.println("IOException");
			  }

		}while (!choice.equals("quit"));

	}//close runPoolVolume


/********************************** END POOL VOLUME ***************************************************************************************/

/******************************** STRANGE RANDOMIZED ARRAY LOOPS ***************************************************************************/

	static void runArrayLoop(){
		String response = "";
		boolean timeToQuit = false;
		do{
			response = promptInterest();
			switch(response){
				case "yes":
					arrayLoop();
					break;
				case "no":
					timeToQuit = true;
					break;
				default:
					System.out.println("Idk what you just typed.. Please enter yes, or no.");
					break;
			}
		}while(!timeToQuit);
	}//close runArrayLoop

	static void arrayLoop(){
		int total = 0;
		int totalOdd = 0;
		int amount = 0;
		int[] numberArray = new int[promptForNumber()];
		for(int i = 0; i<numberArray.length; i++){
		numberArray = loadArray(numberArray);
		printArrayContents(numberArray);
		total += sumArrayContents(numberArray);
		amount += 1;
		totalOdd += sumArrayOddContents(numberArray);
		System.out.printf("***********************************%n");
		}
		getAverage(total, amount, " ");
		getAverage(totalOdd, amount, " odd ");
		System.out.println();
	}//close run

	static int promptForNumber(){
		int response = 0;
		System.out.print("Please enter an integer: ");
		response = getInteger();
	return response;
	}//close promptForNumber;

	static String promptInterest(){
		String response = "";
		System.out.println("Would you like to loop through some sums? ( yes / no )");
		response = scanner.next();
	return response.trim().toLowerCase();
	}//close promptInterest


	static int[] loadArray(int[] tempArray){
		for(int i = 0; i<tempArray.length; i++){
			tempArray[i] = rnd.nextInt(tempArray.length);
		}
	return tempArray;
	}//close loadArray

	static int[] clearArray(int[] tempArray){
		for(int i = 0; i< tempArray.length; i++){
			tempArray[i] = 0;
		}
	System.out.println("Array has been reset to 0.");
	return tempArray;
	}//close clearArray

	static void printArrayContents(int[] printableArray){
		for(int number : printableArray){
			System.out.printf("%d ", number);
		}
	}//close printArrayContents

	static int sumArrayOddContents(int[] sumableArray){
		int sum = 0;
		for (int number : sumableArray){
			if((number % 2) != 0)
			sum += number;
		}
		System.out.printf("The odd numbers in this array sum to: %d%n",sum);
	return sum;
	}//close sumArrayOddContents

	static int sumArrayContents(int[] sumableArray){
		int sum = 0;
		for (int number : sumableArray){
			sum += number;
		}
		System.out.printf("%nSums to: %d%n",sum);
	return sum;
	}//close sumArrayContents

	static void getAverage(int total, int amount,String id){
		int average = total / amount;

		System.out.printf("%nThe total of all%ssums: %d %nThe average%ssum is: %d", id, total, id, average);
	}//close getAverage

/*************************** END OF STRANGE RANDOMIZED ARRAY LOOPS **************************************************************************/

}//close class








//***********SCRATCH*******************************************************************/
	/*static void unenhancedForPrim(int a){
		for(int x = 0; x < a; x++) {
			System.out.println("This was looped by for method!!");
		}
		System.out.println();
	}
	static void whileLoop(int a){
		int x = 0;
		while(x>a){
			System.out.println("This was looped by while method!!");
			x++;
		}
		System.out.println();
	}
	static void doALoop(int a){
		int x = 0;
		do {
		  System.out.println("This was looped by do method!!");
		  a
	}++;
		}while(x>a);
		*/
