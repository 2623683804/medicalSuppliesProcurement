package com.kaiyuan.user.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @program: ccx-axis-change
 * @description: 自定义errorPage拦截器
 * @author: YangPeng
 * @create: 2018-07-11 15:51
 **/
@Component
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {

    private List<Integer> errorCodeList = Arrays.asList(404, 403, 500);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (errorCodeList.contains(response.getStatus())) {
            //捕获异常后进行重定向，controller对应的requestMapping为/error/{code}
            response.sendRedirect("/error/" + response.getStatus());
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}

