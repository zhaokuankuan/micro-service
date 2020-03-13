package com.microservice.gateway.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :Mr.kk
 * @date: 2019/10/18 15:08
 */
@Slf4j
//@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("order {}",1);
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        if(null == token || "".equals(token)){
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is null");
                requestContext.setSendZuulResponse(false);
                return requestContext.getResponse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
