package pl.akademiaspecjalistowit.jokeapp.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeApiProvider implements JokeProvider {
    @Override
    public Joke getJoke() {

        return null;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        return null;
    }

    private JokeDto getJokeDto() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://v2.jokeapi.dev/joke/Any"))
                .build();

        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JokeDto jokeDto = objectMapper.readValue(response.body(), JokeDto.class);

        System.out.println(jokeDto);
        return jokeDto;
    }
}
