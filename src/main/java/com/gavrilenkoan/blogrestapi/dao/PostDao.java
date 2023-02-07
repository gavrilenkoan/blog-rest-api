package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    List<Post> selectPosts();

    List<Post> selectPostsByUserId(Integer userId);

    Integer insertPost(Integer userId, Post post);

    Integer deletePost(Integer id);

    Optional<Post> selectPostById(Integer id);

    Post updatePost(Integer id);

}
