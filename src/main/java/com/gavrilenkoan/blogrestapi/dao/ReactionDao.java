package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Reaction;

import java.util.List;
import java.util.Optional;

public interface ReactionDao {

    List<Reaction> selectReactionsByPostId(Integer postId);

    List<Reaction> selectReactionsByCommentId(Integer commentId);

    Integer insertReactionByPostId(Integer userId, Integer postId, Reaction reaction);

    Integer insertReactionByCommentId(Integer userId, Integer commentId, Reaction reaction);

    Integer deleteReaction(Integer id);

    Optional<Reaction> selectReactionById(Integer id);

    Reaction updateReaction(Integer id);
}
