package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.Utils;
import pl.akademiaspecjalistowit.jokeapp.model.Category;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;
import pl.akademiaspecjalistowit.jokeapp.service.MenuService;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private final JokeService jokeService;

    public UserController(Scanner scanner, JokeService jokeService) {
        this.scanner = scanner;
        this.jokeService = jokeService;
    }

    public void run() {
        scanner = new Scanner(System.in);
        mainMenuOption();
        scanner.close();
    }

    private void mainMenuOption() {
        MenuService.printNameOfApplication();
        while (true) {
            try {
                MenuService.showSelectionMenu();
                String userOption = scanner.nextLine();
                switch (userOption) {
                    case "1":
                        Category.showListCategories();
                        System.out.print("Enter number of category: ");
                        userOption = scanner.nextLine();
                        int intUserOption = Integer.parseInt(userOption);
                        if (!Utils.getListOfCategoryNumbers().contains(intUserOption)) {
                            throw new RuntimeException();
                        }
                        Joke joke = jokeService.getJoke(userOption);
                        System.out.println(joke);
                        break;
                    case "2":
                        joke = jokeService.getJoke();
                        System.out.println(joke);
                        break;
                    case "3":
                        System.exit(0);
                        break;
                    default:
                        throw new RuntimeException("Invalid option. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("This category hasn't jokes!");
            } catch (RuntimeException e) {
                System.out.println("Input correct number menu");
            }
        }
    }
}
