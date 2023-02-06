package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostDaoImpl implements PostDao{

    @Override
    public List<Post> selectPosts() {
        return null;
    }

    @Override
    public Post insertPost(Long userId, Post post) {
        return null;
    }

    @Override
    public Long deletePost(Long id) {
        return null;
    }

    @Override
    public Optional<Post> selectPostById(Long id) {
        return Optional.empty();
    }

    @Override
    public Post updatePost(Long id) {
        return null;
    }
}
