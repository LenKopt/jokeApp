package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.List;

public class Categories {
    private List<String> categories;

    public Categories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "" + categories;
    }

    public List<String> getCategories() {
        return categories;
    }
}
