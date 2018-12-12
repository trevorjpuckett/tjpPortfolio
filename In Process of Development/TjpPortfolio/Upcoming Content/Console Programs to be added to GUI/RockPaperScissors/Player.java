package com.tjp;

public class Player {

    private String mPlayerName;
    private int mPlayerScore;

    public Player(String playerName){
        int playerScore = 0;
        mPlayerScore = playerScore;
        mPlayerName =  playerName;
    }

    public String getPlayerName() {
        return mPlayerName;
    }

    public int getPlayerScore() {
        return mPlayerScore;
    }

    public void addScorePoint(){
        mPlayerScore++;
    }
}
