package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther shkstart
 * @create 2021-11-11-8:50
 */
@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","首页");
        return "index";
    }

    @RequestMapping("/to/a")
    public String Toa(){
        return "level/a";
    }
    @RequestMapping("/to/b")
    public String Tob(){
        return "level/b";
    }
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未授权无法访问";
    }

}
