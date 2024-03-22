package pl.akademiaspecjalistowit.jokeapp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.akademiaspecjalistowit.jokeapp.controller.UserController;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class JokeAppApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        JokeService jokeService = new JokeServiceImpl();
        UserController userController = new UserController(scanner, jokeService);
        userController.run();
    }

}
