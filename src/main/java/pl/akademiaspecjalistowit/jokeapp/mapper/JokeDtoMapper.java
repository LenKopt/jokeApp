package pl.akademiaspecjalistowit.jokeapp.mapper;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;

public interface JokeDtoMapper {
    Joke toJoke(JokeDto jokeDto);
}
