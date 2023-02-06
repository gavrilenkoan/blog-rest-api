package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Reaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReactionDaoImpl implements ReactionDao{

    @Override
    public List<Reaction> selectReactionsByPostId(Long postId) {
        return null;
    }

    @Override
    public List<Reaction> selectReactionsByCommentId(Long commentId) {
        return null;
    }

    @Override
    public Reaction insertReactionByPostId(Long userId, Long postId, Reaction reaction) {
        return null;
    }

    @Override
    public Reaction insertReactionByCommentId(Long userId, Long commentId, Reaction reaction) {
        return null;
    }

    @Override
    public Long deleteReaction(Long id) {
        return null;
    }

    @Override
    public Optional<Reaction> selectReactionById(Long id) {
        return Optional.empty();
    }

    @Override
    public Reaction updateReaction(Long id) {
        return null;
    }
}
