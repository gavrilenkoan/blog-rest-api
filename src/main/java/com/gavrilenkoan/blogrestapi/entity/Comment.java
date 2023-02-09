package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
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
    Integer replyTo;
    List<Comment> replies;
    List<Reaction> reactions;

    public Comment(Integer id, String comment, Date dateOfPublish, Integer postId, Integer userId) {
        this.id = id;
        this.comment = comment;
        this.dateOfPublish = dateOfPublish;
        this.postId = postId;
        this.userId = userId;
    }

    public Comment(Integer id, String comment, Timestamp dateOfPublish, Integer replyTo, Integer userId, Integer postId) {
        this.id = id;
        this.comment = comment;
        this.dateOfPublish = dateOfPublish;
        this.postId = postId;
        this.userId = userId;
        this.replyTo = replyTo;
    }
}
