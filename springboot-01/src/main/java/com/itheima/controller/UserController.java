package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.data.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController  {
    @RequestMapping("/userList")
    public List<User> userList() throws Exception {
        InputStream in =  this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        return lines.stream().map(line -> {
                    String[] parts = line.split(",");
                    Integer id = Integer.parseInt(parts[0]);
                    String userName = parts[1];
                    String password = parts[2];
                    String name = parts[3];
                    Integer age = Integer.parseInt(parts[4]);
                    LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    return new User(id,userName,password,name,age,updateTime);
                }).toList();

    }
}
