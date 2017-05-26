package cn.dintama.controller;


import cn.dintama.entity.User;
import cn.dintama.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Dintama on 2017/5/25.
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/checkHealth")
    @ResponseBody
    public String checkHealth(){
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
            request.setAttribute("user", userByEmail);
        }
        return result.toString();
    }

}
