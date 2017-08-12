package com.company.db.repository.comment;

import com.company.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CommentRepositoryImpl
        extends SimpleJpaRepository<Comment, String>
        implements CommentRepository{

    @Autowired
    public CommentRepositoryImpl(@Qualifier("commentClass") Class<Comment> commentClass, EntityManager em) {
        super(commentClass, em);
    }
}