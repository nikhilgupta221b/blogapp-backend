package com.nikhil.blogapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private String postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
}
