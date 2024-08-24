package com.nikhil.blogapp.repositories;

import com.nikhil.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
