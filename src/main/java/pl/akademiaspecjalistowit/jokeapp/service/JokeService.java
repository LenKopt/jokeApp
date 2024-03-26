package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.util.List;

public interface JokeService{
    Joke getJoke();
    Joke getJoke(String category);
    List<String> getJokeAllCategory() throws IOException, InterruptedException;
}
