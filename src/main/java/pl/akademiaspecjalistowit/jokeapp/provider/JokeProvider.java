package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

public interface JokeProvider {
    Joke getJoke();

    Joke getJokeByCategory(String category);
}
