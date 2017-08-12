package com.company.common.buisness.service.comment;

import com.company.db.repository.comment.CommentRepository;
import com.company.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
public class CommentServiceImpl
        implements CommentService {

    private CommentRepository commentRepository;

    @Override
    @Transactional
    public Comment saveOrUpdate(final Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Autowired
    public void setCommentRepository(@Qualifier("commentRepositoryImpl") CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}