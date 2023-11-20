package ru.nastya.App_for_learning_English.model;

public class Scores  {

    private int scores;

    public Scores(int scores) {
        this.scores = scores;
    }
    public Scores () {

    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void countScores (int scores) {

    }

    @Override
    public String toString() {
        return "Scores{" +
                "scores=" + scores +
                '}';
    }
}
