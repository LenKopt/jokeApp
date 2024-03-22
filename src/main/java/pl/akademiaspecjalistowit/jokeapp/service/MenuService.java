package pl.akademiaspecjalistowit.jokeapp.service;

public class MenuService {
    public static void askUserAboutContinue() {
        System.out.println("Do you want to get next joke?");
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
}
