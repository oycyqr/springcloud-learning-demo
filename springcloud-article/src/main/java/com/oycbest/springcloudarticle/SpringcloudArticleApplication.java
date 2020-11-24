package com.oycbest.springcloudarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudArticleApplication.class, args);
    }

}
