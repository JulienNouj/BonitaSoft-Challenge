package com.example.cookingwebsite.controller;

import com.example.cookingwebsite.model.Recipe;
import com.example.cookingwebsite.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam String keyword) {
        return recipeService.searchRecipes(keyword);
    }
}
