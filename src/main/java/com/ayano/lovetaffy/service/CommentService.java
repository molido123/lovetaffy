package com.ayano.lovetaffy.service;

import com.ayano.lovetaffy.utils.Response;

/**
 * @author huagenda
 */
public interface CommentService {
    Response getComment(Integer userId);
    Response leaveComment(Integer userId,String content,String title);
    Response getAll();
}
