package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemmoryJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;

import java.util.List;
import java.util.Random;

public class JokeDataProvider implements JokeProvider {
    private JokeRepository jokeRepository;

    public JokeDataProvider() {
        this.jokeRepository = new InMemmoryJokeRepository();
    }

    @Override
    public Joke getJoke() {
        Random rand = new Random();
        List<Joke> listJokes = jokeRepository.getAllJokes();
        Joke randomJoke = listJokes.get(rand.nextInt(listJokes.size()));
        return randomJoke;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        Random rand = new Random();
        List<Joke> listJokes = jokeRepository.getAllByCategory(category);
        Joke randomJokeByCategory = listJokes.get(rand.nextInt(listJokes.size()));
        return randomJokeByCategory;
    }
}
