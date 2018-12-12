package com.tjp.consolePrograms.RockPaperScissors;

// best 2 out 3

public class Game {
    // rock beats scissors; rock beats lizard; looses to papper; looses to spock;
    // sciccors beats papper; beats lizard; looses to spock; looses to rock;
    // papper beats rock; beats spock; looses to lizard; looses to scissors;
    // lizard beats papper; beats spock; losses to rock; looses to scissors;
    // spock beats rock; beats scissors; looses to papper; looses to lizard;

    private Player mPlayer1;
    private Player mPlayer2;

    public Game(String player1Name, String player2Name){
        mPlayer1 = new Player(player1Name);
        mPlayer2 = new Player(player2Name);

    }


    public String declareWinner(String answer1, String answer2){
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
            outcome = mPlayer1.getPlayerName() + " wins!";
        } else if(draw){
            outcome = "It's a draw!";
        } else {
            outcome = mPlayer2.getPlayerName() + " wins!";
        }
        return outcome;
    }
    private void rewardWinner(String roundOutcome){
        if(roundOutcome.equals(mPlayer1.getPlayerName() + " wins!")){
            mPlayer1.addScorePoint();
        }else if(roundOutcome.equals(mPlayer2.getPlayerName() + " wins!")){
            mPlayer2.addScorePoint();
        }
    }
  /*  public boolean gameStatus(){
        boolean gameOver = false;
        if ((mPlayer1.getPlayerScore() >= 2)){
            gameOver = true;
        } else if(!(mPlayer2.getPlayerScore() >=2 )){
            gameOver = true;
        }
        return gameOver;
    } NOT NEEDED **** WENT DIFFERENT DIRECTION */

    public void displayCurrentScore(){

        System.out.printf("Current Scores: %n"
                        + "%s: %d   || %s: %d %n%n"
                        + "******************************%n",
                mPlayer1.getPlayerName(),mPlayer1.getPlayerScore(),
                mPlayer2.getPlayerName(),mPlayer2.getPlayerScore());
    }

    public void roundStatus(String answer1, String answer2){
        System.out.printf("%s threw %s, and  %s threw %s %n",
                          mPlayer1.getPlayerName(),answer1,
                          mPlayer2.getPlayerName(), answer2);
        System.out.printf(declareWinner(answer1,answer2) + "%n%n");
            rewardWinner(declareWinner(answer1,answer2));

    }

    public void overAllWinner(){
        if(mPlayer1.getPlayerScore() > mPlayer2.getPlayerScore()) {
            System.out.printf(mPlayer1.getPlayerName() + " is the winner!!%n%n");
        } else {
            System.out.printf(mPlayer2.getPlayerName() + " is the winner!!%n%n");
        }
    }


}
