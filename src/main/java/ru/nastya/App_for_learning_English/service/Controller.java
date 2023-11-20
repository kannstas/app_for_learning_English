package ru.nastya.App_for_learning_English.service;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nastya.App_for_learning_English.enumeration.LearnMode;
import ru.nastya.App_for_learning_English.model.Modes;
import ru.nastya.App_for_learning_English.model.Settings;

import java.io.IOException;
import java.util.Scanner;

@Component
public class Controller {

    private Modes modes;

    Scanner in = new Scanner (System.in);

    public Controller () {
    }

    public Controller(Modes modes) {
        this.modes = modes;
    }


    public void askSettings() {

        System.out.println("Введите количество слов для изучения");
        String wordsToLearn = in.nextLine();
        System.out.printf("Выберете режим \n" +
                "1. %s \n" +
                "2. %s \n", "Перевод русских слов на английский язык", "Перевод английских слов на русский язык");

    }

    @GetMapping("/learn")
    public String choice() throws IOException {
//        model.addAttribute("choice", modes.choice());
        return "/dictionary/choiceMode";

    }


    //private Settings askSettings() {

    // console.showText("Введите количество слов для изучения");
    //  String wordsToLearn = console.acceptResponseFromConsole();

    // System.out.printf("Выберете режим \n" +
    //    "1. %s \n" +
    //   "2. %s \n", "Перевод русских слов на английский язык", "Перевод английских слов на русский язык");

    //     return switch (Integer.parseInt(in.nextLine())) {
    //    case "1" -> new Settings(wordsToLearn, LearnMode.FIRST_ENGLISH);
    //    case "2" -> new Settings(wordsToLearn, LearnMode.FIRST_RUSSIAN);
    //   default -> throw new IllegalStateException("Unacceptable mode");
};
//  }

/*
 private void checkWord(Settings settings) {

        for (int i = 0; i < settings.wordsToLearn(); i++) {
            int randomIndex = random.nextInt(wordKeyToResultMap.size());
            String wordToLearn = resolveDictionary(settings.mode()).get(randomIndex);
            System.out.printf("Введите слово %s на %s%n", wordToLearn, settings.mode().getLangName());

            String userAnswer = in.nextLine();

            Result result = wordKeyToResultMap.get(new WordKey(userAnswer, wordToLearn));
            if (result == null) {
                System.out.println("Не верно");
            } else {
                System.out.println("Верно! \n");

                //добавить баллы
                //System.out.println(result.successLearnsNumber().getAndIncrement());
            }

        }

 */



