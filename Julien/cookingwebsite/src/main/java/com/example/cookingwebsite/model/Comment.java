package com.example.cookingwebsite.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    // Many comments can belong to one recipe, hence the Many-to-One relationship
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // Many comments can be made by one user, hence the Many-to-One relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user who wrote the comment

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
