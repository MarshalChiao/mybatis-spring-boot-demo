package com.kingdee.mybatisspringbootdemoxml.controller;

import com.kingdee.mybatisspringbootdemoxml.bean.User;
import com.kingdee.mybatisspringbootdemoxml.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2019/2/14
 * @Time: Created at 9:36
 * @Description:
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("Marshal");
    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }

    @RequestMapping("/changemoney")
    public List<User> testChangeMoney() {
        userService.changeMoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(5);
        return "OK";
    }
}
