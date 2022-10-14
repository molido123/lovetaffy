package com.ayano.lovetaffy.dao;

import com.ayano.lovetaffy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.plaf.LabelUI;
import java.util.List;

/**
 * @author huagenda
 */
public interface UserRepo extends JpaRepository<User,Object> {
    public List<User> findByUserNameAndUserPassword(String userName, String password);
    public List<User> findByUserId(Integer id);
}