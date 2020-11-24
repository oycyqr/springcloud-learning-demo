package com.oycbest.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName OycZuulFilter
 * @Description zuul过滤器
 * @Author oyc
 * @Date 2020/11/24 14:09
 * @Version
 */
@Component
public class OycZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("经过 zuul Filter：OycZuulFilter");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //登录界面，放行
        if (request.getRequestURL().indexOf("/login") > 0) {
            return null;
        }
        try {
            //获取header
            String authorization = request.getHeader("Authorization");
            // 没有认证信息或者不是admin，不允许访问
            if (authorization != null && authorization.equalsIgnoreCase("admin")) {
                requestContext.addZuulRequestHeader("Authorization", authorization);
                return null;
            }
        } catch (Exception e) {
            //终止运行
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
        }
        //终止运行
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("权限不足");
        requestContext.getResponse().setContentType("text/htm1 ; charset=utf-8");
        return null;
    }
}