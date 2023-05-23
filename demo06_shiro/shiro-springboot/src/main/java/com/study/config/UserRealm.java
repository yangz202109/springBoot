package com.study.config;

import com.study.pojo.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceimpl;
import com.study.utils.SpringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;


/**
 * @auther shkstart
 * @create 2021-11-11-11:10
 */
//自定义的Realm类
public class UserRealm extends AuthorizingRealm {



    //授权 访问控制
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();


        // 设置角色(根据当前用户的自己的角色(role属性)添加到info)
		Set<String> roles = new HashSet<>();
        roles.add(user.getRole());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
     
        //设置权限(根据当前用户的自己的权限(perms属性)添加到info)
        info.addStringPermission(user.getPerms());

        return info;
    }

    //认证 是用来验证用户身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从容器从获取指定的bean对象
        UserService userService = SpringUtil.getBean(UserServiceimpl.class);

        //得到当前登录用户身份信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //判断用户名和密码
        //连接数据库，进行判断
        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null) {  //没有这个人
            return null;   //返回null 抛出异常 UnknownAccountException
        } else {  //有这个人
            //得到session(不是Servlet的),存入当前登录的这个对象
            Subject subject = SecurityUtils.getSubject();
            Session session =subject.getSession();
            session.setAttribute("loginUser",user);

            //可以加密：
            //判断密码，shiro会做
            return new SimpleAuthenticationInfo(user, user.getUpwd(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        }
    }
}