package com.nikhil.blogapp.repositories;

import com.nikhil.blogapp.entities.Category;
import com.nikhil.blogapp.entities.Post;
import com.nikhil.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
