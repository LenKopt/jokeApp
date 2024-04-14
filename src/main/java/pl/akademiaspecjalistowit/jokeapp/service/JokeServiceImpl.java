package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class JokeServiceImpl implements JokeService {
    private List<JokeProvider> jokeProviders;
    private int index;

    public JokeServiceImpl(List<JokeProvider> jokeProviders) {
        this.jokeProviders = jokeProviders;
    }

    @Override
    public Joke getJoke() {
        return getJokeProvider().getJoke();
    }

    @Override
    public Joke getJoke(String category) {

        return jokeProviders.get(index).getJokeByCategory(category);
    }

    public List<String> getJokeAllCategory() throws IOException, InterruptedException {
        return getJokeProvider().getJokeAllCategory();
    }

    private JokeProvider getJokeProvider() {

        Random rand = new Random();
        index = rand.nextInt(jokeProviders.size());

        if (index == 0) {
            System.out.println("---Memory---");
        } else {
            System.out.println("---API---");
        }
        return jokeProviders.get(index);
    }
}
