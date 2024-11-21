package com.example.cookingwebsite.service;

import com.example.cookingwebsite.model.Comment;
import com.example.cookingwebsite.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByRecipeId(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }
}
