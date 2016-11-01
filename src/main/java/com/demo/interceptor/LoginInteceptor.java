package com.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yanlingz on 16/10/31.
 */
public class LoginInteceptor implements HandlerInterceptor{

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        // 通过cookie 获取uid
        Cookie[] cookies= request.getCookies();
        for(Cookie cookie : cookies)
            if (cookie.getName().equals("uid")) {
                String uid = cookie.getValue();
                // 通过 redis 获取登录用户信息
                if (redisTemplate.opsForValue().get(uid)!=null) {
                    return true;
                }
            }
        //没有登陆，转向登陆界面
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }
}
