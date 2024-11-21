package com.example.cookingwebsite.controller;

import com.example.cookingwebsite.model.Comment;
import com.example.cookingwebsite.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/recipe/{recipeId}")
    public List<Comment> getCommentsByRecipe(@PathVariable Long recipeId) {
        return commentService.getCommentsByRecipeId(recipeId);
    }
}
