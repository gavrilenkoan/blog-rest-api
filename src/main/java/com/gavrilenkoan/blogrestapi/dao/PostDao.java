package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {
    List<Post> selectPosts();
    Post insertPost(Long userId, Post post);
    Long deletePost(Long id);
    Optional<Post> selectPostById(Long id);
    Post updatePost(Long id);
}
