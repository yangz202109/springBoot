package com.study.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义的拦截器
 * @author yangz
 * @create 2021-11-04-16:28
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        if (request.getSession().getAttribute("loginUser") == null){
          request.setAttribute("msg","请登录");
          request.getRequestDispatcher("/index.html").forward(request,response);
          return false;
        }else {
            return true;
        }
    }
}
