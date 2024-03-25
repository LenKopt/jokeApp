package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.model.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
    }

    public static List<Integer> getListOfCategoryNumbers() {
        return Arrays.stream(Category.values()).map(category -> category.ordinal() + 1).toList();
    }
}
