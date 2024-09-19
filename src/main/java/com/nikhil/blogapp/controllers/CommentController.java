package com.nikhil.blogapp.controllers;

import com.nikhil.blogapp.payloads.ApiResponse;
import com.nikhil.blogapp.payloads.CommentDto;
import com.nikhil.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {
        CommentDto createdCommentDto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(createdCommentDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully!", true), HttpStatus.OK);
    }
}
