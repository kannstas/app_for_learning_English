package ru.nastya.App_for_learning_English;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nastya.App_for_learning_English.model.Modes;

import java.io.IOException;

@SpringBootApplication
public class AppForLearningEnglishApplication {

    public static void main(String[] args) {
     //   SpringApplication.run(AppForLearningEnglishApplication.class, args);


        Modes mode = new Modes();
        try {
           mode.choice();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}





// режим изучения, где слова на русском, и необходимо написать перевод
