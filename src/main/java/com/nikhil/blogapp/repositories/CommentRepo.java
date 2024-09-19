package com.nikhil.blogapp.repositories;

import com.nikhil.blogapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
