package pl.akademiaspecjalistowit.jokeapp.service;

public class MenuService {
    public static void askUserAboutContinue() {
        System.out.println("Do you want to get next joke?");
        System.out.print("Enter Y/N: ");
    }

    public static void askUserAboutCategory() {
        System.out.println("Do you want to choose the category of joke?");
        System.out.print("Enter Y/N: ");
    }

    public static void printNameOfApplication() {
        System.out.println("-------------APPLICATION JOKES-------------");
        System.out.println();
    }

    public static void askUserAboutShowingCategory() {
        System.out.println("Do you want to see a list of category?");
        System.out.print("Enter Y/N: ");
    }

    public static void showSelectionMenu() {
        System.out.println("Enter 1 - for get joke by category");
        System.out.println("Enter 2 - for get random joke");
        System.out.println("Enter 0 - for exit");
    }

    public static void selectSource() {
        System.out.println("Enter 1 - memory");
        System.out.println("Enter 2 - internet");
    }
}
