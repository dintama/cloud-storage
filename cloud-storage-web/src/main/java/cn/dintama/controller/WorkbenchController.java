package cn.dintama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dintama on 2017/5/27.
 */
@Controller
public class WorkbenchController {


    @RequestMapping(value = "/index")
    public String index(){
        return "workbench/index";
    }

}
