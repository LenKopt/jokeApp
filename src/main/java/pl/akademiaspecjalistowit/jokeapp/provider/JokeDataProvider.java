package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;

import java.util.List;
import java.util.Random;

public class JokeDataProvider implements JokeProvider {
    private List<JokeRepository> jokeRepositories;
    private int index;

    public JokeDataProvider(List<JokeRepository> jokeRepository) {
        this.jokeRepositories = jokeRepository;
    }

    @Override
    public Joke getJoke() {
        Random rand = new Random();
        List<Joke> listJokes = getJokeRepository().getAllJokes();
        Joke randomJoke = listJokes.get(rand.nextInt(listJokes.size()));
        return randomJoke;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        try {
            Random rand = new Random();
            List<Joke> listJokes = jokeRepositories.get(index).getAllByCategory(category);
            Joke randomJokeByCategory = listJokes.get(rand.nextInt(listJokes.size()));
            return randomJokeByCategory;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<String> getJokeAllCategory() {
        return getJokeRepository().getCategories();
    }

    private JokeRepository getJokeRepository() {
        Random rand = new Random();
        index = rand.nextInt(jokeRepositories.size());

        if (index == 0) {
            System.out.println("---Memory---");
        } else {
            System.out.println("---File---");
        }
        return jokeRepositories.get(index);
    }
}
