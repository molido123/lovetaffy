package com.ayano.lovetaffy.service.impl;

import com.ayano.lovetaffy.dao.CommentRepo;
import com.ayano.lovetaffy.dao.UserRepo;
import com.ayano.lovetaffy.entity.Comment;
import com.ayano.lovetaffy.service.CommentService;
import com.ayano.lovetaffy.utils.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

/**
 * @author huagenda
 */
@Service
@Data
public class CommentServiceImplement implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;
    /**
     * @param userId
     * @return
     */
    @Override
    public Response getComment(Integer userId) {
        List<Comment> userComment=commentRepo.findByUserId(userId);
        if (userComment.size()>0){
            return new Response("200",userComment);
        }
        else {
            return new Response("404","Not Found");
        }
    }

    /**
     * @param userId
     * @param content
     * @param title
     * @return
     */
    @Override
    public Response leaveComment(Integer userId, String content, String title) {
        if(userRepo.findByUserId(userId).size()==0){
            return new Response("1000","用户不存在");
        }
        if(content.equals("")||content==null){
            return new Response("1000","请输入内容！");
        }
        if(title.equals("")||title==null){
            return new Response("1000","请输入标题！");
        }
        Comment comment=new Comment();
        comment.setLeaveTime(new Timestamp(System.currentTimeMillis()));
        comment.setTitle(title);
        comment.setUserId(userId);
        comment.setContent(content);
        commentRepo.save(comment);
        return new Response("200","OK");

    }

    /**
     * @return
     */
    @Override
    public Response getAll() {
        List<Comment> comments=commentRepo.findAll();
        if(comments.isEmpty()){
            return new Response("404","No Data");
        }
        return new Response("200",comments);
    }
}
