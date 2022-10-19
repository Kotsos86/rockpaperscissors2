package com.stensaxpase;

public class Player {
    private String name;
    private int wins;
    public boolean isAi;
    public Fist playedFist;

    public Player(String name) {
        this.name = name;
    }
    public Player(boolean isAi) {
        this.isAi = true;
        this.name = "Ai";
    }

    public Fist getPlayedFist() {
        return playedFist;
    }

    public void setPlayedFist(Fist playedFist) {
        this.playedFist = playedFist;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }


}
