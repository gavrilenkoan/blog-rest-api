package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.dto.ReactionDto;
import com.gavrilenkoan.blogrestapi.entity.Reaction;

import java.util.List;
import java.util.Optional;

public interface ReactionDao {

    List<Reaction> selectReactionsByPostId(Integer postId);

    List<Reaction> selectReactionsByCommentId(Integer commentId);

    void insertReactionByPostId(Integer userId, Integer postId, ReactionDto reactionDto);

    void insertReactionByCommentId(Integer userId, Integer commentId, ReactionDto reactionDto);

    void deleteReaction(Integer id);

    Optional<Reaction> selectReactionById(Integer id);

    void updateReaction(Integer id, ReactionDto reactionDto);

    boolean ReactionUserPostRelationExists(Integer userId, Integer postId);

    boolean ReactionUserCommentRelationExists(Integer userId, Integer commentId);
}
