package com.nikhil.blogapp.services;

import com.nikhil.blogapp.entities.Post;
import com.nikhil.blogapp.payloads.PostDto;
import com.nikhil.blogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // get single post
    PostDto getPostById(Integer postId);

    // get post by category
    List<PostDto> getPostByCategory(Integer categoryId);

    // get post by User
    List<PostDto> getPostByUser(Integer userId);

    // search post
    List<PostDto> searchPostsByTitle(String keyword);
}
