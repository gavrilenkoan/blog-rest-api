package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reaction {

    Integer id;
    Boolean reaction;
    Integer userId;
    Integer postId;
    Integer commentId;

    public Reaction(Integer id, Boolean reaction, Integer userId, Integer postId, Integer commentId) {
        this.id = id;
        this.reaction = reaction;
        this.userId = userId;
        this.postId = postId;
        this.commentId = commentId;
    }
}
