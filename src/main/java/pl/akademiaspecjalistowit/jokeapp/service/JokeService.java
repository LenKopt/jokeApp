package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

public interface JokeService {
    Joke getJoke();
    Joke getJoke(String category);
}
