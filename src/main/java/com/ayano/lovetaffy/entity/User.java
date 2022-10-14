package com.ayano.lovetaffy.entity;

import lombok.Data;
import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.*;
import java.sql.Timestamp;
/**
 * @author huagenda
 */
@Data
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "user_id",length = 8)
    private Integer userId;
    @Column(nullable = false,name = "user_name",length = 40)
    private String userName;
    @Column(nullable = false,name = "password",length = 40)
    private String userPassword;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, name = "register_time")
    private Timestamp registerTime;

}

