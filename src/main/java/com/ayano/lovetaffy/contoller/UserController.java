package com.ayano.lovetaffy.contoller;
import com.ayano.lovetaffy.service.CommentService;
import com.ayano.lovetaffy.service.UserService;
import com.ayano.lovetaffy.utils.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @author huagenda
 */
@org.springframework.stereotype.Controller
@Data
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @PostMapping(value = "register")
    @ResponseBody
    public Response Register(@RequestParam("userName")String userName,@RequestParam("password") String password){
            return  userService.userRegister(userName,password);
    }

    @PostMapping(value = "login")
    @ResponseBody
    public Response Login(@RequestParam("userName")String userName,@RequestParam("password") String password){
        return userService.userLogin(userName,password);
        }
    @PostMapping(value = "getUser")
    @ResponseBody
    public Response getUser(@RequestParam("id")Integer id){
        return userService.getUser(id);
    }

    @PostMapping(value = "getall")
    @ResponseBody
    public Response getAll(){
        return userService.getAllUsers();
    }
}

