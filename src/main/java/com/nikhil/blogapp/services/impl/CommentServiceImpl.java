package com.nikhil.blogapp.services.impl;

import com.nikhil.blogapp.entities.Comment;
import com.nikhil.blogapp.entities.Post;
import com.nikhil.blogapp.exceptions.ResourceNotFoundException;
import com.nikhil.blogapp.payloads.CommentDto;
import com.nikhil.blogapp.repositories.CommentRepo;
import com.nikhil.blogapp.repositories.PostRepo;
import com.nikhil.blogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        commentRepo.delete(comment);
    }
}
