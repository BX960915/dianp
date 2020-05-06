package fun.baoxiang.dianpingspringboot.controller;

import fun.baoxiang.dianpingspringboot.entity.User;
import fun.baoxiang.dianpingspringboot.result.Result;
import fun.baoxiang.dianpingspringboot.result.ResultFactory;
import fun.baoxiang.dianpingspringboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            User user = userService.findByUsername(username);
            if (user.isEnabled()) {
                return ResultFactory.buildFailResult("该用户已被禁用");
            }
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);

        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }
   @ResponseBody
   @CrossOrigin
   @PostMapping(value = "/api/register")
   public Result register(@RequestBody User registeruser){
       int status = userService.register(registeruser);
       switch (status) {
           case 0:
               return ResultFactory.buildFailResult("用户名和密码不能为空");
           case 1:
               return ResultFactory.buildSuccessResult("注册成功");
           case 2:
               return ResultFactory.buildFailResult("用户已存在");
       }
       return ResultFactory.buildFailResult("未知错误");
   }

}
