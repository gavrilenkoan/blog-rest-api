package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Reaction;

import java.util.List;
import java.util.Optional;

public interface ReactionDao {
    List<Reaction> selectReactionsByPostId(Long postId);
    List<Reaction> selectReactionsByCommentId(Long commentId);
    Reaction insertReactionByPostId(Long userId, Long postId, Reaction reaction);
    Reaction insertReactionByCommentId(Long userId, Long commentId, Reaction reaction);
    Long deleteReaction(Long id);
    Optional<Reaction> selectReactionById(Long id);
    Reaction updateReaction(Long id);
}
