package com.tjp;


import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;


public class Prompter {


    private Map<String,String> mTypeMenu;
    private Scanner scanner = new Scanner(System.in);

    public Prompter(){
        mTypeMenu =  new TreeMap<>();
            mTypeMenu.put("PvP","Player versus Player");
            mTypeMenu.put("PvC","Player versus Computer");
            mTypeMenu.put("CvC","Computer versus Computer");
            mTypeMenu.put("Quit","Quit the game.");

    }

    public String promptGameType(){
        String type;
            System.out.println("Type one of the following acronyms to play the game type: ");
            for (Map.Entry<String,String> gameType : mTypeMenu.entrySet()){
                    System.out.printf("%s, %s %n",
                                      gameType.getKey(),gameType.getValue());
            }
            System.out.print("What would you like to do? ");
            type = scanner.next();
        return type.toLowerCase().trim();
    }
    public int promptNumberOfRounds(){
        System.out.println("Please enter the number of rounds you'd like to play the best of");
        int numberOfRounds = scanner.nextInt();
        return numberOfRounds;
    }


    public String promptPlayerName(){
        String displayName;
        System.out.print("Choose your display name:  ");
        displayName = scanner.next().trim();
        return displayName;
    }


    public void createBuffer(){
        for(int x=0; x<25; x++){
            System.out.println("************************** CREATING BUFFER ******************************");
            System.out.println("**************************** DON'T CHEAT ********************************");
        }
    }

    public String promptForAnswer(){
        System.out.println("Choose wisely!");
        System.out.println("Rock, Paper, Scissors, Lizard, or Spock?");
        String answer =  getAnswer();
        return answer;
        }

    public String getAnswer(){
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
    }


}
