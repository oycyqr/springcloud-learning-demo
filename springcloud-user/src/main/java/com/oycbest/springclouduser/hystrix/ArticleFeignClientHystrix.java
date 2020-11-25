package com.oycbest.springclouduser.hystrix;


import com.oycbest.springclouduser.client.ArticleFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserClientHystrix
 * @Description TODO
 * @Author oyc
 * @Date 2020/11/25 13:39
 * @Version
 */
@Component
public class ArticleFeignClientHystrix implements ArticleFeignClient {

    /*@Override
    public String getArticle(String name) {
        return "sorry " + name + " 上游服务断开, 服务降级";
    }

    @Override
    public String timeOut() throws InterruptedException {
        return "链接超时，服务降级";
    }

    @Override
    public String exception() throws Exception {
        return "发生异常，服务降级";
    }*/

    @Override
    public List articlelist() {
        return new ArrayList() {{
            add("发生异常，服务降级");
        }};
    }
}