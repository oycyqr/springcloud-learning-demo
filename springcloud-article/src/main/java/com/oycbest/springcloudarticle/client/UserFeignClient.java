package com.oycbest.springcloudarticle.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName UserFeignClient
 * @Description 用户服务类
 * @Author oyc
 * @Date 2020/11/25 11:06
 * @Version
 */
@FeignClient(value = "cloudServerUser")//,path = "user")
public interface UserFeignClient {
    /**
     * 获取所有文章
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    List userlist();
}