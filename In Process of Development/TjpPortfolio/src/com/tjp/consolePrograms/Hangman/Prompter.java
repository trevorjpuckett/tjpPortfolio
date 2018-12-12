package com.tjp.consolePrograms.Hangman;

import java.util.Scanner;

class Prompter{
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            System.out.print("Enter a letter:   ");
            String guessInput = scanner.nextLine();

            try {
                isAcceptable = true;
                isHit = game.applyGuess(guessInput);
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. %n",
                        iae.getMessage());
            }
        } while (! isAcceptable);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d attempts to solve:  %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }

    public void displayOutcome() {
        if (game.isWon()) {
            System.out.printf(" Congratulations B, you just won hangman dawg in only %s shots. %n wanna go again? %n",
                    game.getShots());
        } else {
            System.out.printf(" Bad news bro... That cowbow died.. and it's YOUR FAULT! %n The word was: %s. %n wanna go again? %n",
                    game.getAnswer());
        }
    }

}
