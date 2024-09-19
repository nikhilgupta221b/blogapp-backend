package com.nikhil.blogapp.services;

import com.nikhil.blogapp.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
