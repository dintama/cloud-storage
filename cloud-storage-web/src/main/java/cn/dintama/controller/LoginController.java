package cn.dintama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dintama on 2017/5/25.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/checkHealth")
    @ResponseBody
    public String checkHealth(){
        return "ok";
    }

}
