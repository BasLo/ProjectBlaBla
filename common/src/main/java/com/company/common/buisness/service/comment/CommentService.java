package com.company.common.buisness.service.comment;

import com.company.domain.entity.Comment;

public interface CommentService {

    Comment add(Comment comment);

    void update(Comment comment);

    void delete(Comment comment);

    Comment getCommentById(String id);
}
