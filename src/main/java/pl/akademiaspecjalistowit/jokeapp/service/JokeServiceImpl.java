package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;

import java.util.List;

public class JokeServiceImpl implements JokeService {
    private List<JokeProvider> jokeProviders;
    private static long counter = 0;

    public JokeServiceImpl(List<JokeProvider> jokeProviders) {

        this.jokeProviders = jokeProviders;

    }

    @Override
    public Joke getJoke() {
        return getJokeProvider().getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        return getJokeProvider().getJokeByCategory(category);
    }

    private JokeProvider getJokeProvider() {
        return jokeProviders.get((int) counter++ % jokeProviders.size());
    }
}
