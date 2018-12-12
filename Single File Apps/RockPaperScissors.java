
import java.io.*;
import java.util.*;


public class RockPaperScissors {

	static Scanner scanner = new Scanner(System.in);
	static Random rnd = new Random();
	static Map<String,String> rpsMenu = new TreeMap<>();
	static List<String> computerAnswerPool = new ArrayList<>();

		static String player1Name = "";
		static String player2Name = "";

		static int player1Score = 0;
		static int player2Score = 0;

		static String roundResult = "";

	public static void main(String[] args){
		run();


	}//close main
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
    static void run(){
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




}//close class