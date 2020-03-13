package com.microservice.gateway.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :Mr.kk
 * @date: 2019/10/18 14:43
 */
@Slf4j
//@Component
public class MyFilter extends ZuulFilter {

    //pre：路由之前
    //routing：路由之时
    //post： 路由之后
    //error：发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器执行的顺序
    @Override
    public int filterOrder() {
        log.info("order {}",2);
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        //if(accessToken == null) {
        //    log.warn("token is empty");
        //    ctx.setSendZuulResponse(false);
        //    ctx.setResponseStatusCode(401);
        //    try {
        //        ctx.getResponse().getWriter().write("token is empty");
        //    }catch (Exception e){}
        //
        //    return null;
        //}
        return "ok";
    }
}
