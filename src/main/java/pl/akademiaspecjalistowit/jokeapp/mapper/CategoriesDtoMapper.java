package pl.akademiaspecjalistowit.jokeapp.mapper;

import pl.akademiaspecjalistowit.jokeapp.model.Categories;
import pl.akademiaspecjalistowit.jokeapp.model.CategoriesDto;

public interface CategoriesDtoMapper {
    static Categories toCategories(CategoriesDto categoriesDto) {
        return new Categories(categoriesDto.getCategories());
    }
}
