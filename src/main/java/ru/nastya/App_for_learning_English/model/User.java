package ru.nastya.App_for_learning_English.model;

public class User {
    private String name;
   private  Scores scores;

    public User(String name, Scores scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}
   // String login, String password,