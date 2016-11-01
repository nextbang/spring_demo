package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yanlingz on 16/10/29.
 */


@Controller
@RequestMapping("/")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestBody(required = false) String body,
                        @RequestHeader(value = "User-Agent") String user_agent,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model) {

        // logger params
        logger.debug("body:" + body);
        logger.debug("user_agent:" + user_agent);

        // add cookie
        response.addCookie(new Cookie("uid", "1"));
        logger.debug(request.getCookies());

        // set redis
        redisTemplate.opsForValue().set("1", "i had login.");
        logger.debug("redis_value:" + String.valueOf(redisTemplate.opsForValue().get("yunlongm")));

        model.addAttribute("status", "自动登录成功!");
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(@CookieValue(value = "uid") String uid, ModelAndView view, HttpServletRequest request) {

        User user = null;
        if(uid!=null){
            user = userService.findOne(Integer.valueOf(uid));
        }
        view.addObject("user", user);

        return view;
    }

}
