package com.oycbest.springclouduser.controller;

import com.oycbest.springclouduser.client.ArticleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    @Autowired
    private Environment environment;

    @Autowired
    private ArticleFeignClient articleFeignClient;

    @GetMapping
    public List list() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("小明");
        list.add("小花");
        list.add("小红");
        list.add("小秋");
        try {
            String eurekaServiceUrl = environment.getProperty("eureka.client.serviceUrl.defaultZone");
            System.out.println("eureka.serviceUrl" + eurekaServiceUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping("article")
    public List listUserArticle() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("小明");
        list.add("小花");
        list.add("小红");
        list.add("小秋");
        try {
            list.add(articleFeignClient.articlelist());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}