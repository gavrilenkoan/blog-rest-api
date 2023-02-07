package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.ReactionDao;
import com.gavrilenkoan.blogrestapi.entity.Reaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReactionDas implements ReactionDao {

    @Override
    public List<Reaction> selectReactionsByPostId(Integer postId) {
        return null;
    }

    @Override
    public List<Reaction> selectReactionsByCommentId(Integer commentId) {
        return null;
    }

    @Override
    public Integer insertReactionByPostId(Integer userId, Integer postId, Reaction reaction) {
        return null;
    }

    @Override
    public Integer insertReactionByCommentId(Integer userId, Integer commentId, Reaction reaction) {
        return null;
    }

    @Override
    public Integer deleteReaction(Integer id) {
        return null;
    }

    @Override
    public Optional<Reaction> selectReactionById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Reaction updateReaction(Integer id) {
        return null;
    }
}
