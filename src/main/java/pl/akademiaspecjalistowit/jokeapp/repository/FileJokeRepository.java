package pl.akademiaspecjalistowit.jokeapp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileJokeRepository implements JokeRepository {
    private final Map<String, List<Joke>> fileRepository;

    public FileJokeRepository(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            fileRepository = objectMapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Joke>>() {
                    })
                    .stream()
                    .collect(Collectors.groupingBy(Joke::getCategory));
        } catch (IOException e) {
            throw new RuntimeException("File was not readed", e);
        }
    }

    @Override
    public List<Joke> getAllJokes() {
        return fileRepository
                .entrySet()
                .stream()
                .flatMap(categorySetEntry -> categorySetEntry.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return fileRepository.get(category);
    }

    @Override
    public List<String> getCategories() {
        return fileRepository
                .entrySet()
                .stream()
                .map(nextItem -> nextItem.getKey())
                .collect(Collectors.toList());
    }
}
