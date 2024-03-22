package pl.akademiaspecjalistowit.jokeapp.service;

import javax.swing.plaf.PanelUI;

public class MenuService {
    public static void printQuestionForUser() {
        System.out.println("Do you want to get next joke?");
        System.out.print("Enter Y/N: ");
    }

    public static void printNameOfApplication() {
        System.out.println("-------------APPLICATION JOKES-------------");
        System.out.println();
    }
}
