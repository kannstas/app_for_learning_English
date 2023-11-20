package ru.nastya.App_for_learning_English.service;

import ru.nastya.App_for_learning_English.enumeration.LearnMode;
import ru.nastya.App_for_learning_English.model.Settings;

import java.util.Scanner;

public class Console {

    static Scanner in = new Scanner(System.in);


    public Settings askSettings() {
        showText("Введите количество слов для изучения");
        String wordsToLearn = acceptResponseFromConsole();
        showText("Выберете режим \n" +
                "1. %s \n" +
                "2. %s \n", "Перевод русских слов на английский язык", "Перевод английских слов на русский язык");
        return switch (acceptResponseFromConsole()) {
            case "1" -> new Settings(wordsToLearn, LearnMode.FIRST_ENGLISH);
            case "2" -> new Settings(wordsToLearn, LearnMode.FIRST_RUSSIAN);
            default -> throw new IllegalStateException("Unacceptable mode");

        };
    }


    public Console() {
    }

    public void showText(String string) {
        System.out.println(string);
    }

    public void showText(String s1, String s2, String s3) {
        System.out.printf(s1, s2, s3);
    }


    public String acceptResponseFromConsole() {
        String answer = in.nextLine();
        return answer;
    }


}



