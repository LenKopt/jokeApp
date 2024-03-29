package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.controller.UserController;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeApiProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.FileJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemmoryJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JokeAppApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        List<JokeRepository> jokeRepositories = List.of(new InMemmoryJokeRepository(), new FileJokeRepository("src/main/resources/jokes.txt"));

        List<JokeProvider> jokeProviders = List.of(new JokeDataProvider(jokeRepositories), new JokeApiProvider(HttpClient.newHttpClient()));
        JokeService jokeService = new JokeServiceImpl(jokeProviders);

        UserController userController = new UserController(scanner, jokeService);
        userController.run();
    }

}
