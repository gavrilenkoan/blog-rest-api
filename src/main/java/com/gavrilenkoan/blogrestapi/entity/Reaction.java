package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reaction {

    Long id;
    Boolean reaction;
    Long userId;
    Long postId;
    Long commentId;
}
