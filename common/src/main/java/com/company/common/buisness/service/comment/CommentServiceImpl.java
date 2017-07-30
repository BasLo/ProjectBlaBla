package com.company.common.buisness.service.comment;

import com.company.db.dao.CommentDao;
import com.company.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    @Transactional
    public Comment add(Comment comment) {
        return commentDao.create(comment);
    }

    @Override
    @Transactional
    public void update(Comment comment) {
        commentDao.update(comment);
    }

    @Override
    @Transactional
    public void delete(Comment comment) {
        commentDao.delete(comment);
    }

    @Override
    public Comment getCommentById(String id) {
        return commentDao.read(id);
    }

}
