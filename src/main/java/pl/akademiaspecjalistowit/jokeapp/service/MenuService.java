package pl.akademiaspecjalistowit.jokeapp.service;

public class MenuService {
    public static void printNameOfApplication() {
        System.out.println("-------------APPLICATION JOKES-------------");
        System.out.println();
    }
    public static void showSelectionMenu() {
        System.out.println("Enter 1 - for get joke by category");
        System.out.println("Enter 2 - for get random joke");
        System.out.println("Enter 0 - for exit");
    }
}
