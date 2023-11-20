package ru.nastya.App_for_learning_English.service;

import java.util.Scanner;

public class Console {

    static Scanner in = new Scanner(System.in);

    public Console() {
    }

    public void showText (String string) {
        System.out.println(string);
    }

    public void showText (String s1, String s2, String s3) {
        System.out.printf(s1, s2, s3);
    }



    public String acceptResponseFromConsole () {
        String answer = in.nextLine();
        return answer;
    }



}
