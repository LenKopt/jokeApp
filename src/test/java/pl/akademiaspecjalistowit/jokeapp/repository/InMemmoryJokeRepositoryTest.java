package pl.akademiaspecjalistowit.jokeapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemmoryJokeRepositoryTest {

    InMemmoryJokeRepository inMemmoryJokeRepository;

    @BeforeEach
    void setUp() {
        inMemmoryJokeRepository = new InMemmoryJokeRepository();
    }

    @Test
    void schould_get_all_jokes_from_memory_repository() {
        //given
        //when
        List<Joke> listJokes = inMemmoryJokeRepository.getAllJokes();
        //then
        assertThat(listJokes.size()).isEqualTo(3);
        assertThat(listJokes.get(0).getCategory()).isEqualTo("Christmas");
        assertThat(listJokes).isNotNull();
    }

    @Test
    void getAllByCategory() {
        //when
        List<Joke> listJokes = inMemmoryJokeRepository.getAllByCategory("Christmas");
        //then
        assertThat(listJokes.size()).isEqualTo(2);
    }

    @Test
    void getCategories() {
        //given
        //when
        List<String> listCategories = inMemmoryJokeRepository.getCategories();
        //then
        assertThat(listCategories.size()).isEqualTo(2);
    }
}