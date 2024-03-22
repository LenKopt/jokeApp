package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.controller.UserController;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class JokeAppApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        JokeService jokeService = new JokeServiceImpl();
        UserController userController = new UserController(scanner, jokeService);
        userController.run();
    }

}
