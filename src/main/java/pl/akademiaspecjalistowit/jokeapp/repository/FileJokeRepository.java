package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;

public class FileJokeRepository implements JokeRepository{
    @Override
    public List<Joke> getAllJokes() {
        return null;
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return null;
    }

    @Override
    public List<String> getCategories() {
        return null;
    }
}
