package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Comment {

    Long id;
    String comment;
    Date dateOfPublish;
    Long postId;
    Long userId;
    List<Comment> replies;
    List<Reaction> reactions;
}
