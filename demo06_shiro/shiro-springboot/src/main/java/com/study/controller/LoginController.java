package com.study.controller;

import com.study.pojo.User;
import com.study.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @auther shkstart
 * @create 2021-11-11-13:55
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping({"/tologin"})
    public String ToLogin(){
      return "login";
    }
    @RequestMapping("/toregist")
    public String Toregist(){
        return "regist";
    }


    @PostMapping("/login")
    public String login(String username, String password, Model model) {

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {

            currentUser.login(token);//其会自动委托给 Security Manager，如果没有异常(登录成功)

            model.addAttribute("user",username);
            return "index";

        }catch (UnknownAccountException e){ //当用户名不存在(报异常，进入)
            //System.out.println("用户名错误");
             model.addAttribute("msg","用户名错误");
             return "forward:/tologin";
        }catch (IncorrectCredentialsException e){ //当密码不存在(报异常，进入)
            //System.out.println("密码错误");
            model.addAttribute("msg","密码错误");
            return "forward:/tologin";
        }

    }
    @PostMapping("/regist")
    public String Regist(User user){
        userService.addUser(user);
        return "redirect:/";
    }


    @RequestMapping("/logout")
    public String LogOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/";
    }
}
