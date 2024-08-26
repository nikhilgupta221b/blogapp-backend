package com.nikhil.blogapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;

    @Column(length = 10000)
    private String content;
    private String imageName;
    private Date addedDate;

    // category id
    @ManyToOne
    private Category category;

    // user id
    @ManyToOne
    private User user;
}
