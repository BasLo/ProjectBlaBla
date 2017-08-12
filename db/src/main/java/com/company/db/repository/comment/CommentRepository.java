package com.company.db.repository.comment;

import com.company.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository
    extends JpaRepository<Comment, String> {
}
