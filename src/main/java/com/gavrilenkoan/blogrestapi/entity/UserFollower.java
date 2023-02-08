package com.gavrilenkoan.blogrestapi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFollower {

    private Integer id;
    private Integer userId;
    private Integer followerId;

    public UserFollower(Integer id, Integer userId, Integer followerId) {
        this.id = id;
        this.userId = userId;
        this.followerId = followerId;
    }
}
