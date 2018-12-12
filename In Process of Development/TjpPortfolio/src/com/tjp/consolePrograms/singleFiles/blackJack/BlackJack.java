package com.tjp.consolePrograms.singleFiles.blackJack;

import java.util.*;


public class BlackJack {

	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);

	static String userName = "";
	static String dealerName = "Dealer";
	static List<String> deck = new ArrayList<>();
	static List<String> userHand = new ArrayList<>();
	static List<String> dealerHand = new ArrayList<>();
	static int currentUserScore = 0;
	static int currentDealerScore = 0;
	static double userBank = 50;
	static double pot = 0;


/*	public static void main(String[] agrs){

		runBlackJack();
	}//close main */
	public BlackJack(){

	}

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

}//close class