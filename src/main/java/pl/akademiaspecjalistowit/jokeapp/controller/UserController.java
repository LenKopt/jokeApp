package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.MenuService;

import java.io.IOException;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private JokeService jokeService;

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
                        System.out.println("You have next categories " + jokeService.getJokeAllCategory());
                        System.out.print("Enter category for search: ");
                        userOption = scanner.nextLine();
//                        int intUserOption = Integer.parseInt(userOption);
//                        if (!Utils.getListOfCategoryNumbers().contains(intUserOption)) {
//                            throw new RuntimeException();
//                        }
                        Joke joke = jokeService.getJoke(userOption);
                        System.out.println(joke);
                        break;
                    case "2":
                        joke = jokeService.getJoke();
                        System.out.println(joke);
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        throw new RuntimeException("Invalid option. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("This category hasn't jokes!");
            } catch (RuntimeException e) {
                System.out.println("Input correct number menu");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
