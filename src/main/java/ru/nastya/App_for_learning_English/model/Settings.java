package ru.nastya.App_for_learning_English.model;


import org.springframework.stereotype.Component;
import ru.nastya.App_for_learning_English.enumeration.LearnMode;

@Component
public class Settings {
    private String wordsToLearn;
    private LearnMode mode;


    public Settings(String wordsToLearn, LearnMode mode) {
        this.wordsToLearn = wordsToLearn;
        this.mode = mode;
    }

    public Settings () {

    }

    public String getWordsToLearn() {
        return wordsToLearn;
    }

    public void setWordsToLearn(String wordsToLearn) {
        this.wordsToLearn = wordsToLearn;
    }

    public LearnMode getMode() {
        return mode;
    }

    public void setMode(LearnMode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "wordsToLearn='" + wordsToLearn + '\'' +
                ", mode=" + mode +
                '}';
    }
}