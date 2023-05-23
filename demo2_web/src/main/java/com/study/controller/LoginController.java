package com.study.controller;

import com.study.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Map;


/**登录判断(用户名和密码-添加session)
 * @auther shkstart
 * @create 2021-11-04-15:36
 */
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;

//  登录
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
     //1.判断用户名和密码
        if(userMapper.existOneByName(username)!=null && userMapper.existOneByPass(password)!=null){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }




//    注销
    @RequestMapping("/cancel")
    public String Cancel(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/receive/{id}/{name}")
    public void receive(@PathVariable Map<String,String> msg){

        System.out.println(msg.get("id"));
        System.out.println(msg.get("name"));

    }
}
