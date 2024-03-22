package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;

public interface JokeRepository {
    List<Joke> getAllJokes();
    List<Joke> getAllByCategory(String category);
}
