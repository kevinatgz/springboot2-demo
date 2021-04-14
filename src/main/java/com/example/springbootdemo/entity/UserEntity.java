package com.example.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springbootdemo.enums.UserSexEnum;
import lombok.Data;
import lombok.ToString;

@Data
@TableName("users")
@ToString
public class UserEntity {

    public UserEntity(String userName, String passWord, UserSexEnum userSex){
        this.userName = userName;
        this.passWord  =passWord;
        this.userSex = userSex;
//        this.nickName = userName;

    }
    private String userName;

    private String passWord;

    private UserSexEnum userSex;

    private String nickName;

    @TableId(type = IdType.AUTO)
    private Long id;
}
