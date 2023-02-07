package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.PostDao;
import com.gavrilenkoan.blogrestapi.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostDas implements PostDao {

    @Override
    public List<Post> selectPosts() {
        return null;
    }

    @Override
    public List<Post> selectPostsByUserId(Integer userId) {
        return null;
    }

    @Override
    public Integer insertPost(Integer userId, Post post) {
        return null;
    }

    @Override
    public Integer deletePost(Integer id) {
        return null;
    }

    @Override
    public Optional<Post> selectPostById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Post updatePost(Integer id) {
        return null;
    }
}
