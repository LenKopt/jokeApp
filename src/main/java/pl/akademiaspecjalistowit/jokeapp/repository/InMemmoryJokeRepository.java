package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Category;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.*;
import java.util.stream.Collectors;

public class InMemmoryJokeRepository implements JokeRepository {
    Map<Category, Set<Joke>> dataBaseJokes;

    public InMemmoryJokeRepository() {
        this.dataBaseJokes = new HashMap<>();
        fillByDefault();
    }

    private void fillByDefault() {
        dataBaseJokes.put(Category.CHRISTMAS, Set.of(new Joke("Why does Santa go down the chimney?", "Because it soots him!")
                , new Joke("What's the most notable similarity between a pedophile and a roller coaster?", "They both make a child scream, but the first ride's never the last")));

        dataBaseJokes.put(Category.PROGRAMMING, Set.of(new Joke("Why did the Python data scientist get arrested at customs?", "She was caught trying to import pandas!")));
    }

    @Override
    public List<Joke> getAllJokes() {
        return dataBaseJokes
                .entrySet()
                .stream()
                .flatMap(categorySetEntry -> categorySetEntry.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Joke> getAllByCategory(String category) {

        return dataBaseJokes
                .entrySet()
                .stream()
                .filter(joke -> joke.getKey().name().equalsIgnoreCase(category))
                .flatMap(categorySetEntry -> categorySetEntry.getValue().stream())
                .collect(Collectors.toList());
    }
}
