package com.itheima.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  用户信息
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
//    public User( Integer id,String userName,String password,String name, Integer age,LocalDateTime updateTime){
//
//    }
}
