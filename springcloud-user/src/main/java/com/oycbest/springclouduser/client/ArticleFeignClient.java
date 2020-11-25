package com.oycbest.springclouduser.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description 文章服务类
 * @Author oyc
 * @Date 2020/11/25 11:06
 * @Version
 */
@FeignClient(value = "springcloudArticle")//,path = "article")
public interface ArticleFeignClient {
    /**
     * 获取所有文章
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    List articlelist();
}