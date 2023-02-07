package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Comment {

    Integer id;
    String comment;
    Date dateOfPublish;
    Integer postId;
    Integer userId;
    List<Comment> replies;
    List<Reaction> reactions;
}
