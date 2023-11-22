package ru.nastya.App_for_learning_English.model;


import java.util.concurrent.atomic.AtomicInteger;

public record Result (boolean isLearned, AtomicInteger successLearnsNumber) {
    }



