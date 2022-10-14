package com.ayano.lovetaffy.entity;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author huagenda
 */
@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "comment_id",length = 11)
    private Integer commentId;
    @Column(nullable = false, name = "user_id",length = 8)
    private Integer userId;
    @Column(nullable = false, length = 20,name = "title")
    private String title;
    @Column(nullable = false, name = "content")
    private String content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, name = "comment_time")
    private Timestamp leaveTime;
}