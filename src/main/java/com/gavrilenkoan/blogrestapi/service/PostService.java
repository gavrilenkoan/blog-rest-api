package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.dao.PostDao;
import com.gavrilenkoan.blogrestapi.dto.PostDto;
import com.gavrilenkoan.blogrestapi.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PostService {

    private final PostDao postDao;

    public List<Post> getAllPosts() {
        return  postDao.selectPosts();
    }

    public List<Post> getUsersPosts(Integer userId) {
        return postDao.selectPostsByUserId(userId);
    }

    public Post getPost(Integer postId) {
        return postDao.selectPostById(postId)
                .orElseThrow(IllegalStateException::new);
    }

    public String createPost(Integer userId, PostDto postDto) {
        postDao.insertPost(userId, postDto);
        return "inserted successfully";
    }

    public Post updatePost(Integer userId, Integer postId, PostDto postDto) {

        Post post = postDao.selectPostById(postId)
                .orElseThrow(() -> new IllegalStateException("post with id " + postId + "not found"));
        if (!Objects.equals(post.getUserId(), userId)) {
            throw new IllegalStateException("you can not edit this post");
        }
        if (postDto.getTitle() != null && !Objects.equals(postDto.getTitle(), "")) {
            postDao.updatePostTitle(postId, postDto.getTitle());
            post.setTitle(postDto.getTitle());
        }
        if (postDto.getText() != null && !Objects.equals(postDto.getText(), "")) {
            postDao.updatePostText(postId, postDto.getText());
            post.setText(postDto.getText());
        }
        return post;
    }

    public String deletePost(Integer userId, Integer postId) {
        if (!Objects.equals(postDao.selectPostById(postId)
                .orElseThrow(() -> new IllegalStateException("post with id " + postId + "not found"))
                .getUserId(), userId)) {
            throw new IllegalStateException("you can not delete this post");
        }
        postDao.deletePost(postId);
        return "deleted successfully";
    }
}
