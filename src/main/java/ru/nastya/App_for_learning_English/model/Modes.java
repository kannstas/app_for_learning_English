package ru.nastya.App_for_learning_English.model;

import org.springframework.stereotype.Component;
import ru.nastya.App_for_learning_English.enumeration.LearnMode;
import ru.nastya.App_for_learning_English.service.AppController;
import ru.nastya.App_for_learning_English.service.Console;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Modes {

    private List<String> englishWords = new ArrayList<>();
    private List<String> russianWords = new ArrayList<>();
    private Map<WordKey, Result> wordKeyToResultMap = new HashMap<>();

    private Map<String, String> englishAndRussianWordsAreKeysInMap = new HashMap<>();

    static Random random = new Random();

    private Scores scores = new Scores();

    private Console console = new Console();


    private User user = new User(new String(), new Scores());

    static Scanner in = new Scanner(System.in);


    public void choice() throws IOException {
        fileInMap();
        searchRightWordInFile();
        // learnWord(.askSettings()); // можно попытаться с помощью if менять методы
        // в зависимости от того, чем пользуется пользователь (консолью или браузером)
        // checkWord(askSettingsController())
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


    private void searchRightWordInFile() {
        Path path = Paths.get("src/main/resources/checkingWords.txt");
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(word -> {
                String[] words = word.split(",");
                englishAndRussianWordsAreKeysInMap.put(words[0], words[1]);
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void learnWord(Settings settings) {
        int points = 0;

        for (int i = 0; i < Integer.parseInt(settings.getWordsToLearn()); i++) {
            int randomIndex = random.nextInt(wordKeyToResultMap.size());
            String wordToLearn = resolveDictionary(settings.getMode()).get(randomIndex);

            console.showText("Введите слово %s на %s%n", wordToLearn, settings.getMode().getLangName()); // ??? как сделать универсально

            String userAnswer = in.nextLine();
            Result result = wordKeyToResultMap.get(new WordKey(userAnswer, wordToLearn));
            if (result == null) {
                System.out.println("Не верно");
                System.out.println("Верный ответ: " + englishAndRussianWordsAreKeysInMap.get(wordToLearn));
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

}


