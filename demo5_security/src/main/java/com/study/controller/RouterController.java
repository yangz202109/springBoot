package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangz
 * @create 2021-11-09-14:32
 */
@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String login1(){
        return "views/login";
    }

    @RequestMapping("/LoginOut")
    public String login2(){
        return "redirect:/";
    }


    //VIP1可以访问
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable int id){
        return "views/level1/"+id;
    }

    //VIP2可以访问
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable int id){
        return "views/level2/"+id;
    }

    //VIP3可以访问
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable int id){
        return "views/level3/"+id;
    }
}
