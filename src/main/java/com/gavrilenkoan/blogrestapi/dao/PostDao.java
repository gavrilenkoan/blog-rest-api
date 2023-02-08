package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.dto.PostDto;
import com.gavrilenkoan.blogrestapi.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    List<Post> selectPosts();

    List<Post> selectPostsByUserId(Integer userId);

    void insertPost(Integer userId, PostDto postDto);

    void deletePost(Integer id);

    Optional<Post> selectPostById(Integer id);

    void updatePostTitle(Integer id, String title);

    void updatePostText(Integer id, String text);
}
