package com.ayano.lovetaffy.contoller;
import com.ayano.lovetaffy.service.*;
import com.ayano.lovetaffy.service.CommentService;
import com.ayano.lovetaffy.utils.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author huagenda
 */
@Data
@Controller
@EnableAutoConfiguration
@RequestMapping("/comments")
public class CommentController {
    @Autowired
        CommentService commentService;
    @Autowired
        UserService userService;

    @PostMapping(value = "/getall")
    @ResponseBody
    public Response getAll() {
        return commentService.getAll();
    }

    @PostMapping(value = "/getcomments")
    @ResponseBody
    public Response getComments(@RequestParam("userId")Integer userId){
        return commentService.getComment(userId);
    }

    @PostMapping(value = "/leavecomments")
    @ResponseBody
    public Response leave(@RequestParam("userId") Integer userId,@RequestParam("content") String content,@RequestParam("title")String title){
        return commentService.leaveComment(userId,content,title);
    }

}
