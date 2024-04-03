package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.*;
import java.util.stream.Collectors;

public class InMemmoryJokeRepository implements JokeRepository {
    private Map<String, Set<Joke>> dataBaseJokes;

    public InMemmoryJokeRepository() {
        this.dataBaseJokes = new HashMap<>();
        fillByDefault();
    }

    private void fillByDefault() {
        dataBaseJokes.put("Christmas", Set.of(new Joke("Why does Santa go down the chimney?" + '\n' + "Because it soots him!", "Christmas")
                , new Joke("What's the most notable similarity between a pedophile and a roller coaster?" + '\n'+"They both make a child scream, but the first ride's never the last", "Christmas")));

                        dataBaseJokes.put("Programowanie", Set.of(new Joke("Why did the Python data scientist get arrested at customs?"+'\n'+"She was caught trying to import pandas!", "Programming")));
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
                .filter(joke -> joke.getKey().equalsIgnoreCase(category))
                .flatMap(categorySetEntry -> categorySetEntry.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCategories() {
        return dataBaseJokes
                .entrySet()
                .stream()
                .map(nextItem->nextItem.getKey())
                .collect(Collectors.toList());
    }
}
