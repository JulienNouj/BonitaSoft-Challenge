package com.example.cookingwebsite.service;

import com.example.cookingwebsite.model.Recipe;
import com.example.cookingwebsite.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> searchRecipes(String keyword) {
        return recipeRepository.findByKeywordsContaining(keyword);
    }
}
