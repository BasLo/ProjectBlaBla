package com.company.db.dao.impl;

import com.company.db.dao.CommentDao;
import com.company.db.dao.generic.GenericDaoJpaImpl;
import com.company.domain.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl
        extends GenericDaoJpaImpl<Comment, String>
        implements CommentDao {
}
