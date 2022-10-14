package com.ayano.lovetaffy.service.impl;
import com.ayano.lovetaffy.dao.UserRepo;
import com.ayano.lovetaffy.entity.User;
import com.ayano.lovetaffy.service.UserService;
import com.ayano.lovetaffy.utils.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author huagenda
 */
@Service
@Data
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepo userRepo;
    /**
     * @param id
     * @return
     */
    @Override
    public Response getUser(Integer id) {
        List<User> user=userRepo.findByUserId(id);
        if(user.isEmpty()){
            return new Response("400","Not Found");
        }
        return new Response("200",user);
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Response userRegister(String userName, String password) {
        if(!userName.isEmpty()&&!password.isEmpty()){

            try {
                User user=new User();
                user.setUserName(userName);
                user.setUserPassword(password);
                user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
                userRepo.save(user);
                return new Response("200","ok");
            }
            catch (Exception e){
                return new Response("1000","用户插入异常！");
            }
        }
        return new Response("200","illegal input");
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Response userLogin(String userName, String password) {
        List<User> users=userRepo.findByUserNameAndUserPassword(userName,password);
        if(users.size()==0){
            return new Response("1000","密码错误或账号不存在");
        }
        else {
            return new Response("200","ok");
        }
    }

    /**
     * @return
     */
    @Override
    public Response getAllUsers() {
        List<User> users=userRepo.findAll();
        if(users.size()==0){
            return new Response("400","No Data");
        }
        return new Response("200",users);
    }
}
