package com.oycbest.springcloudarticle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArticleController
 * @Description 文章控制器
 * @Author oyc
 * @Date 2020/11/24 13:59
 * @Version
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @GetMapping
    public List list() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("一千零一夜1");
        list.add("一千零一夜2");
        list.add("一千零一夜3");
        list.add("一千零一夜4");
        return list;
    }
}