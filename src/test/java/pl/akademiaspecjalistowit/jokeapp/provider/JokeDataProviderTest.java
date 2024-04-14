package pl.akademiaspecjalistowit.jokeapp.provider;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemmoryJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class JokeDataProviderTest {
    @Test
    public void successfully_receiving_joke_specified_category() {
        // given
        String category = "programowanie";
        JokeRepository jokeRepository = Mockito.mock(InMemmoryJokeRepository.class);
        Mockito.when(jokeRepository.getAllByCategory(category)).thenReturn(getJokes(category));
        JokeProvider jokeDataProvider = new JokeDataProvider(List.of(jokeRepository));
        // when
        Joke joke = jokeDataProvider.getJokeByCategory(category);
        // then
        assertThat(joke).isNotNull();
    }

    private List<Joke> getJokes(String category) {

        Map<String, Set<Joke>> jokes = new HashMap<>();
        jokes.put("Christmas", Set.of(new Joke("content 1", "Christmas")
                , new Joke("content 2", "Christmas")));

        jokes.put("Programowanie", Set.of(new Joke("content 3", "Programming")));
        return jokes
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getKey().equalsIgnoreCase(category))
                .flatMap(entrySet -> entrySet.getValue().stream()).collect(Collectors.toList());
    }

}