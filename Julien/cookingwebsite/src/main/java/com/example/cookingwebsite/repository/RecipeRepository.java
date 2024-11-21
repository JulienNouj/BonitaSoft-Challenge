package com.example.cookingwebsite.repository;

import com.example.cookingwebsite.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Custom query method to find recipes by keyword
    List<Recipe> findByKeywordsContaining(String keyword);
}
