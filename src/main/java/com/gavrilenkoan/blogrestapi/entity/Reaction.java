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
}
