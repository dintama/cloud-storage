package cn.dintama.controller;


import cn.dintama.dao.UserDao;
import cn.dintama.entity.User;
import cn.dintama.service.UserService;
import cn.dintama.utils.RedisDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dintama on 2017/5/25.
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    @Resource
    private RedisDataSource redisDataSource;

    @RequestMapping(value = "/checkHealth")
    @ResponseBody
    public String checkHealth(){
        redisDataSource.set("test", "test");
        return "ok";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @RequestMapping(value = "/signUp")
    public String signUp(HttpServletRequest request){
        return "signUp";
    }

    @RequestMapping(value = "/validate/login", method = RequestMethod.POST)
    @ResponseBody
    public String validateLogin(HttpServletRequest request, User user){
        Boolean result = userService.validateLogin(user);
        if(result){
            User userByEmail = userService.getUserByEmail(user.getEmail());
            request.getSession().setAttribute("user", userByEmail);
        }
        return result.toString();
    }

    @RequestMapping(value = "/validate/signUp", method = RequestMethod.POST)
    @ResponseBody
    public String validateSignUp(HttpServletRequest request, User user){
        return userService.validateSignUp(user).toString();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request, User user){
        userDao.insertUser(user);
        return "success";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

}
