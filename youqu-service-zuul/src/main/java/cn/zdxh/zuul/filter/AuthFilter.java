package cn.zdxh.zuul.filter;

import cn.zdxh.commons.utils.JwtUtils;
import cn.zdxh.commons.utils.ResultHelper;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限验证 Filter
 * 注册和登录接口不过滤
 */
@Component
public class AuthFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AuthFilter.class);


    //排除过滤的 uri 地址
    private static final String LOGIN_URI = "/user/tUser/login";
    private static final String ADMIN_LOGIN_URI = "/user/tUser/admin/login";
    private static final String REGISTER_URI = "/user/tUser/register";
    private static final String SEND_MSG_URI = "/user/tUser/send";


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("======zuul======", request.getRequestURI());
        //注册和登录接口不拦截，其他接口都要拦截校验 token
        String uri = request.getRequestURI();
        if (LOGIN_URI.equals(uri) || REGISTER_URI.equals(uri) || ADMIN_LOGIN_URI.equals(uri) || SEND_MSG_URI.equals(uri)) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        response.setContentType("application/json;charset=utf-8");

        //从header取出token
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            setUnauthorizedResponse(requestContext, "权限受限！请登录后访问！");
        } else {
            boolean verify = JwtUtils.verify(token);
            if (!verify){
                setUnauthorizedResponse(requestContext, "token已失效！");
            }
        }
        return null;
    }

    /**
     * 设置 405 无权限状态
     */
    private void setUnauthorizedResponse(RequestContext requestContext, String msg) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        String result = JSON.toJSONString(ResultHelper.createUnauthorizedError(msg));
        requestContext.setResponseBody(result);
    }
}