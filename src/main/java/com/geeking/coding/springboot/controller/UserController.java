package com.geeking.coding.springboot.controller;

import com.geeking.coding.springboot.base.ResultEntity;
import com.geeking.coding.springboot.entity.SysUser;
import com.geeking.coding.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * User: devils
 * Date: 2018/12/5
 */
@Api("user-controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("login-restful")
    @GetMapping("/login")
    public ResultEntity login(@ApiParam(name = "User对象，name和password") SysUser user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
//            SysUser result = userService.findByName(user.getName());
            SysUser result = (SysUser) subject.getPrincipal();
            return new ResultEntity(200, "success", result);
        }catch (UnknownAccountException e){
            //找不到用户名
            return new ResultEntity(401, e.getMessage(),null);
        }catch (IncorrectCredentialsException e){
            //密码不正确
            return new ResultEntity(402, e.getMessage(),null);
        }
    }

}
