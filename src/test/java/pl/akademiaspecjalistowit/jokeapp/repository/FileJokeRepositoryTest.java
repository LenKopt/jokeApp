package pl.akademiaspecjalistowit.jokeapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;

import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileJokeRepositoryTest {
    private FileJokeRepository fileJokeRepository;

    @BeforeEach
    void setUp() {
        fileJokeRepository = new FileJokeRepository("src/main/resources/jokes.txt");
    }

    @Test
    void getAllJokes() {
        //given
        //when
        List<Joke> listJokes = fileJokeRepository.getAllJokes();
        //then
        assertThat(listJokes.size()).isEqualTo(10);
        //assertThat(listJokes.get(0).getCategory()).isEqualTo("Christmas");
        assertThat(listJokes).isNotNull();
    }

    @Test
    void getAllByCategory() {
        //when
        List<Joke> listJokes = fileJokeRepository.getAllByCategory("Pun");
        //then
        assertThat(listJokes.size()).isEqualTo(2);
    }

    @Test
    void getCategories() {
        //given
        //when
        List<String> listCategories = fileJokeRepository.getCategories();
        //then
        assertThat(listCategories.size()).isEqualTo(4);
    }

    @Test
    void throwing_IOexeption() {
        //given

        //when
        Executable e = () -> new FileJokeRepository("src/main/resources/jokes_ex.txt");

        //then
        assertThrows(RuntimeException.class, e);

    }
}