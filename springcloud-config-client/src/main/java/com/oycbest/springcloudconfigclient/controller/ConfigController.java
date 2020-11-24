package com.oycbest.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/11/24 9:52 下午
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private Environment environment;

    @Value("${oycbest.name}")
    private String oycbestName;

    @GetMapping
    public String getOycbestName() {
        return oycbestName;
    }

    @RequestMapping("/get/{name}")
    public String getConfig(@PathVariable String name) {
        return environment.getProperty(name);
    }
}
