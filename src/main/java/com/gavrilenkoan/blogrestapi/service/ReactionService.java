package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.dao.ReactionDao;
import com.gavrilenkoan.blogrestapi.dto.ReactionDto;
import com.gavrilenkoan.blogrestapi.entity.Reaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ReactionService {

    private final ReactionDao reactionDao;

    public List<Reaction> getReactionsByPostId(Integer postId) {
        return reactionDao.selectReactionsByPostId(postId);
    }

    public List<Reaction> getReactionsByCommentId(Integer commentId) {
        return reactionDao.selectReactionsByCommentId(commentId);
    }

    public Reaction getReactionsById(Integer id) {
        return reactionDao.selectReactionById(id)
                .orElseThrow(() -> new IllegalStateException("reaction with id " + id + " not found"));
    }

    public String createReactionByPostId(Integer userId, Integer postId, ReactionDto reactionDto) {
        if (reactionDao.ReactionUserPostRelationExists(userId, postId)) {
            throw new IllegalStateException("such relation already exists");
        }
        reactionDao.insertReactionByPostId(userId, postId, reactionDto);
        return "inserted successfully";
    }

    public String createReactionByCommentId(Integer userId, Integer commentId, ReactionDto reactionDto) {
        if (reactionDao.ReactionUserCommentRelationExists(userId, commentId)) {
            throw new IllegalStateException("such relation already exists");
        }
        reactionDao.insertReactionByCommentId(userId, commentId, reactionDto);
        return "inserted successfully";
    }

    public Reaction updateReaction(Integer userId, Integer reactionId, ReactionDto reactionDto) {
        Reaction reaction = reactionDao.selectReactionById(reactionId)
                .orElseThrow(() -> new IllegalStateException("reaction with id " + reactionId + " not found"));
        if (!Objects.equals(reaction.getUserId(), userId)) {
            throw new IllegalStateException("you can not edit this reaction");
        }
        reactionDao.updateReaction(reactionId, reactionDto);
        reaction.setReaction(reactionDto.getReaction());
        return reaction;
    }

    public String deleteReaction(Integer userId, Integer reactionId) {
        if (!Objects.equals(reactionDao.selectReactionById(reactionId)
                .orElseThrow().getUserId(), userId)) {
            throw new IllegalStateException("you can not delete this reaction");
        }
        reactionDao.deleteReaction(reactionId);
        return "deleted successfully";
    }
}
