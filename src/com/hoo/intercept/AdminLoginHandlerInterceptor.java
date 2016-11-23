package com.hoo.intercept;

import com.hoo.entity.Admin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class AdminLoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Admin admin=(Admin) session.getAttribute("admin");
        if(admin==null){
            response.sendRedirect(request.getContextPath()+"/admin_login");
            return false;
        }
        return true;
    }

}
