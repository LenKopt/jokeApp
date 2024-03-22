package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.UUID;

public class Joke {
    private UUID id;
    private String content;
    private String category;

    public Joke(String content, String category) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.category = category;
    }

    @Override
    public String toString() {
        return '\n' + content + '\n' +
                category + '\'' + '\n';
    }
}
