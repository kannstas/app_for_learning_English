package ru.nastya.App_for_learning_English.enumeration;

public enum LearnMode {
    FIRST_RUSSIAN("русском"),
    FIRST_ENGLISH("английском"),
    ;
    private String langName;

    LearnMode(String langName) {
        this.langName = langName;
    }

    public String getLangName() {
        return langName;
    }
}
