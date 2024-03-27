package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.util.List;

public interface JokeProvider {
    Joke getJoke();
    Joke getJokeByCategory(String category);
    List<String> getJokeAllCategory() throws IOException, InterruptedException;
}
