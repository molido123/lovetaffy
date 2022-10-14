package com.ayano.lovetaffy.dao;

import com.ayano.lovetaffy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author huagenda
 */
public interface CommentRepo extends JpaRepository<Comment,Object> {
    List<Comment> findByUserId(Integer userId);
}
