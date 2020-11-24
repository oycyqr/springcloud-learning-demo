package com.oycbest.springclouduser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName controller
 * @Description 用户控制器
 * @Author oyc
 * @Date 2020/11/24 13:50
 * @Version
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List list() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("小明");
        list.add("小花");
        list.add("小红");
        list.add("小秋");
        return list;
    }
}