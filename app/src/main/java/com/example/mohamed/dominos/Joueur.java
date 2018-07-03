package com.example.mohamed.dominos;

import java.util.ArrayList;

public class Joueur {
    private String name;
    private int Score;
    ArrayList<Tuile> hand =new ArrayList<>();

    public Joueur(String name, int score) {
        this.name = name;
        Score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
