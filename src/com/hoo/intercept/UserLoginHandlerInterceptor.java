package com.hoo.intercept;

import com.hoo.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by palagend on 2016/11/25.
 */
public class UserLoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         User user = (User) request.getSession().getAttribute("user");
        if(user!=null) return true;
        response.sendRedirect(request.getContextPath());
        return false;
    }
}
