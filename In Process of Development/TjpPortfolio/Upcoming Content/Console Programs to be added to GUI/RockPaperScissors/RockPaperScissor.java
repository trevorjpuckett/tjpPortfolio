package com.tjp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockPaperScissor {

    private Game game;
    private Prompter prompter;
    private List<String> mComputerAnswerPool;
    private Random rnd = new Random();

    public RockPaperScissor(){
        prompter = new Prompter();
        mComputerAnswerPool = new ArrayList<>();
            mComputerAnswerPool.add("rock");
            mComputerAnswerPool.add("paper");
            mComputerAnswerPool.add("scissors");
            mComputerAnswerPool.add("lizard");
            mComputerAnswerPool.add("spock");

    }

    public void run(){
        String gameType;
        boolean timeToQuit = false;
        do {
            gameType = prompter.promptGameType();
            boolean  gameOver = false;
            int n;
            switch (gameType){
                case "pvp":
                    Game pvpGame = new Game(prompter.promptPlayerName(),prompter.promptPlayerName());
                    n = prompter.promptNumberOfRounds();
                    for(int x = 0; x < n; x++) {
                        System.out.printf("Rounds left: %d %n", (n-x));
                        pvpGame.displayCurrentScore();
                        String player1Answer = prompter.promptForAnswer();
                            prompter.createBuffer();
                        String player2Answer = prompter.promptForAnswer();
                        pvpGame.roundStatus(player1Answer,player2Answer);
                        if (pvpGame.declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }
                        //gameOver = pvpGame.gameStatus();
                    }
                    pvpGame.displayCurrentScore();
                    pvpGame.overAllWinner();
                break;
                case "pvc":
                   Game pvcGame = new Game(prompter.promptPlayerName(),"Computer Player");
                   n = prompter.promptNumberOfRounds();
                    for(int x = 0; x < n; x++){
                        System.out.printf("Rounds left: %d %n", (n-x));
                        pvcGame.displayCurrentScore();
                        String player1Answer = prompter.promptForAnswer();
                            //prompter.createBuffer();
                        String player2Answer = computerAnswer();
                        pvcGame.roundStatus(player1Answer,player2Answer);
                        if (pvcGame.declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }
                         //gameOver = pvcGame.gameStatus();
                    }
                    pvcGame.displayCurrentScore();
                    pvcGame.overAllWinner();
                break;
                case "cvc":
                    Game cvcGame = new Game("Computer Player 1","Computer Player 2");
                    n = prompter.promptNumberOfRounds();
                    for(int x = 0; x <= n; x++){
                        System.out.printf("Rounds left: %d %n", (n-x));
                        cvcGame.displayCurrentScore();
                        String player1Answer = computerAnswer();
                        //prompter.createBuffer();
                        String player2Answer = computerAnswer();
                        cvcGame.roundStatus(player1Answer,player2Answer);
                        if (cvcGame.declareWinner(player1Answer,player2Answer).equals("It's a draw!")){
                            x--;
                        }
                        //gameOver = pvcGame.gameStatus();
                    }
                    cvcGame.displayCurrentScore();
                    cvcGame.overAllWinner();
                break;
                case "quit":
                    System.out.printf("Thanks for playing!%n%n");
                    timeToQuit = true;
                break;
                default :
                    System.out.printf("Unknown entry.. Please try again!%n%n");
                break;
            }
        }while(!timeToQuit);
    }

    private String computerAnswer(){
        String computerThrows = mComputerAnswerPool.get(rnd.nextInt(mComputerAnswerPool.size()));
        return computerThrows;
    }
}
