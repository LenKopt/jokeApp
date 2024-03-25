package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;

public class JokeServiceImpl implements JokeService {
    private JokeProvider jokeProvider;

    public JokeServiceImpl() {
        jokeProvider = new JokeDataProvider();
    }

    @Override
    public Joke getJoke() {
        return jokeProvider.getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        return jokeProvider.getJokeByCategory(category);
    }
}
