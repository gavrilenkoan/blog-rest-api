package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Post {

    Integer id;
    String title;
    String text;
    Integer userId;
    List<Comment> comments;
    List<Reaction> reactions;

    public Post(Integer id, String title, String text, Integer userId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userId = userId;
    }
}
