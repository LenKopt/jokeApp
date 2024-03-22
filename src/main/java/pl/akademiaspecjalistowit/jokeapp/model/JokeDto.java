package pl.akademiaspecjalistowit.jokeapp.model;

public class JokeDto {
    private String category;
    private String setup;
    private String delivery;

    private JokeDto() {
    }

    public String getCategory() {
        return category;
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return "JokeDto{" +
            "category='" + category + '\'' +
            ", setup='" + setup + '\'' +
            ", delivery='" + delivery + '\'' +
            '}';
    }
}
