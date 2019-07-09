package com.github.web.controller;


import com.github.web.entity.User;
import com.github.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 16:49
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Autowired
    private SessionDAO sessionDAO;
    @PostMapping("login")
    public void login(@RequestParam("username")String username, @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        // 因为已经配置了凭证验证器，所以这里的password就不用手动进行加密了
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 登录验证
        subject.login(token);
        System.out.println(subject.getSession().getId());
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();

        if (subject.isAuthenticated()){
            //遍历所有的session做这个功能其实不是个好方法，一般用数据库存储token的方式做
            for (Session activeSession : activeSessions) {
                //方法一、当第二次登录时，给出提示“用户已登录”，停留在登录页面
                User user = (User) activeSession.getAttribute("curUser");
                //if (Objects.equals(user.getUserName(),username)){
                //    activeSessions.remove(activeSession);
                //    subject.logout();
                //    throw new RuntimeException("用户已登录");
                //}
                //方法二、当第二次登录时，把第其他同账号的session剔除
                if (Objects.equals(user.getUserName(),username) && activeSession.getId() != subject.getSession().getId()){
                    activeSession.setTimeout(0);
                }
            }

        }



    }

    @GetMapping("/test")
    public String test(){
        return "ok";
    }

    @GetMapping("/index")
    public String index(){
        return "login-success";
    }
}
