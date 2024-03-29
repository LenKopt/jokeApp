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
    private Joke(){

    }
    @Override
    public String toString() {
        return '\n' + content + '\n' +
                category + '\n';
    }

    public String getCategory() {
        return category;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
