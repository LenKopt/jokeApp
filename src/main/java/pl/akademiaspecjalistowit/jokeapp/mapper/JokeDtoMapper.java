package pl.akademiaspecjalistowit.jokeapp.mapper;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;

public interface JokeDtoMapper {
    static Joke toJoke(JokeDto jokeDto) {
        return new Joke(jokeDto.getSetup() + "\n" + jokeDto.getDelivery(),
                jokeDto.getCategory());
    }
}
