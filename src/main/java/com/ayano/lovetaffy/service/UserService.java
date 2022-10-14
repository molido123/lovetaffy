package com.ayano.lovetaffy.service;

import com.ayano.lovetaffy.utils.Response;

/**
 * @author huagenda
 */
public interface UserService {
    Response getUser(Integer id);
    Response userRegister(String userName,String password);
    Response userLogin(String userName,String password);
    Response getAllUsers();
}
