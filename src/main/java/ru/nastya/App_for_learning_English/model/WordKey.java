package ru.nastya.App_for_learning_English.model;

import java.util.Objects;

public record WordKey(String firstWord, String secondWord) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordKey wordKey = (WordKey) o;
        return (
                Objects.equals(firstWord, wordKey.firstWord)
                        && Objects.equals(secondWord, wordKey.secondWord)
        ) || (
                Objects.equals(firstWord, wordKey.secondWord)
                        && Objects.equals(secondWord, wordKey.firstWord)
        )
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstWord) + Objects.hash(secondWord);

    }
}

