package com.zoctan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 不同生命周期的过滤器类型
     * pre：在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post： 在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return 生命周期
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义过滤器的执行顺序
     * 数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否要执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 包括查询数据库中的权限信息
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        // 获取 GET 参数 token
        Object token = request.getParameter("token");
        if (token == null) {
            log.warn("token is empty");
            // 过滤该请求，不往下级服务去转发请求，到此结束
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
            return null;
        }
        // 如果有token，则进行路由转发
        log.info("token ok");
        // 这里return的值没有意义，zuul框架没有使用该返回值
        return null;
    }
}