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
    User user;
    List<Comment> comments;
    List<Reaction> reactions;
}
