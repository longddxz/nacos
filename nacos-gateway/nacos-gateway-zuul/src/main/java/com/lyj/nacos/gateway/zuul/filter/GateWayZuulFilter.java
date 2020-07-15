package com.lyj.nacos.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 11:27
 *
 * 校验器
 */
public class GateWayZuulFilter extends ZuulFilter {
    //过滤器的类型，决定过滤器在请求的哪个生命周期中执行，这里的“pre”代表在请求被转发之前执行
    private final String FILTER_TYPE = "pre";

    //过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值依次执行
    private final int FILTER_ORDER = 0;

    //判断该过滤器是否执行（true为执行，false不执行），若该值为true时即执行的话是会执行run()方法
    private final boolean SHOULD_FILTER = true;

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String accessToken = request.getParameter("accessToken");
        if (StringUtils.isNotBlank(accessToken)){
            System.out.println("accessToken->"+accessToken);
        } else {
            try {
                requestContext.getResponse().getWriter().write("accessToken is empty!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
