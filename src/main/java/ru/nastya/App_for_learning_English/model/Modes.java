package ru.nastya.App_for_learning_English.model;

import org.springframework.stereotype.Component;
import ru.nastya.App_for_learning_English.enumeration.LearnMode;
import ru.nastya.App_for_learning_English.service.Console;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Component
public class Modes {

    private List<String> englishWords = new ArrayList<>();
    private List<String> russianWords = new ArrayList<>();
    private Map<WordKey, Result> wordKeyToResultMap = new HashMap<>();

    static Random random = new Random();

    private Scores scores = new Scores();

    private Console console = new Console();

    private User user = new User(new String(), new Scores());


    public void choice() throws IOException {
        fileInMap();
        checkWord(askSettings());
    }


    private Settings askSettings() {

        console.showText("Введите количество слов для изучения");
        String wordsToLearn = console.acceptResponseFromConsole();

        console.showText("Выберете режим \n" +
                "1. %s \n" +
                "2. %s \n", "Перевод русских слов на английский язык", "Перевод английских слов на русский язык");

        return switch (console.acceptResponseFromConsole()) {
            case "1" -> new Settings(wordsToLearn, LearnMode.FIRST_ENGLISH);
            case "2" -> new Settings(wordsToLearn, LearnMode.FIRST_RUSSIAN);
            default -> throw new IllegalStateException("Unacceptable mode");
        };
    }


    private List<String> resolveDictionary(LearnMode mode) {
        return switch (mode) {
            case FIRST_ENGLISH -> russianWords;
            case FIRST_RUSSIAN -> englishWords;
        };
    }

    private void fileInMap() throws IOException {
        Path path = Paths.get("src/main/resources/words.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(word -> {
                String[] words = word.split(",");

                wordKeyToResultMap.put(
                        new WordKey(words[0], words[1]),
                        new Result(false, new AtomicInteger())
                );
                englishWords.add(words[0]);
                russianWords.add(words[1]);

            });

        }


    }

    private void checkWord(Settings settings) {
        int points = 0;

        for (int i = 0; i < Integer.parseInt(settings.wordsToLearn()); i++) {
            int randomIndex = random.nextInt(wordKeyToResultMap.size());
            String wordToLearn = resolveDictionary(settings.mode()).get(randomIndex);

            console.showText("Введите слово %s на %s%n", wordToLearn, settings.mode().getLangName());

            String userAnswer = console.acceptResponseFromConsole();

            Result result = wordKeyToResultMap.get(new WordKey(userAnswer, wordToLearn));
            if (result == null) {
                System.out.println("Не верно");
               // System.out.println("Верный ответ " + wordKeyToResultMap.get(new WordKey(wordToLearn, ))); //???????????????????
            } else {
                //добавить количество успешных попыток
                //  System.out.println(result.successLearnsNumber().getAndIncrement());
                scores.setScores(points += 1);
                System.out.println("Верно! Количество баллов " + points);
            }

        }
        System.out.println(scores.getScores());

        User user1 = new User("Anastasiia", new Scores(scores.getScores()));

        System.out.println(user1);

    }

    public WordKey getTheKey(Map<WordKey, Result> map, String string) {
        WordKey key = null;
        for (Map.Entry<WordKey, Result> entry : map.entrySet()) {
            if (entry.getKey().equals(string)) {
                key = entry.getKey();
            }
        }
        return key;
    }
}



/*
 for (Map.Entry<WordKey, Result> entry : map.entrySet()) {
            if (entry.getKey().equals(string)) {
                string = String.valueOf(entry.getKey());
            }
 */