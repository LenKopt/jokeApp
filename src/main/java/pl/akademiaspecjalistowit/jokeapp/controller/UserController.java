package pl.akademiaspecjalistowit.jokeapp.controller;

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
//        List<User> listOfUsers = fileService.getUsersFromFile();
//        loginService.setUsers(listOfUsers);
//        Map<LocalDate, List<Visit>> visitsFromFile = fileService.getVisitsFromFile();
//        visitService.setListVisits(visitsFromFile);
        mainMenuOption();
        scanner.close();
    }

    private void mainMenuOption() {
        MenuService.printNameOfApplication();
        while (true) {
            try {
                MenuService.printQuestionForUser();
                String userOption = scanner.nextLine().toUpperCase();
                switch (userOption) {
                    case "Y":
                        Joke joke = jokeService.getJoke();
                        break;
                    case "N":
                        System.exit(0);
                        break;
                    default:
                        throw new RuntimeException("Invalid option. Please choose a valid option.");
                }
            } catch (RuntimeException e) {
                System.out.println("Input correct number menu");
            }
        }
    }
}
