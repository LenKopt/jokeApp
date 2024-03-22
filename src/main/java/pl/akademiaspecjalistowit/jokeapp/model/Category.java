package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.Arrays;

public enum Category {
    PROGRAMMING, MISC, DARK, PUN, SPOOKY, CHRISTMAS;

    public static void showListCategories() {
        System.out.println(Arrays
                .stream(values())
                .toList());
    }

    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "1 - PROGRAMMING";
            case 1:
                return "2 - MISC";
            case 2:
                return "3 - DARK";
            case 3:
                return "4 - PUN";
            case 4:
                return "5 - SPOOKY";
            case 5:
                return "6 - CHRISTMAS";
            default:
                return null;
        }
    }
}
