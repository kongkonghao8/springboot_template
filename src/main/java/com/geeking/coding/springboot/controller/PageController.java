package com.geeking.coding.springboot.controller;

import com.geeking.coding.springboot.base.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * User: devils
 * Date: 2018/12/5
 */
@RestController
@Api(value="page-controller")
public class PageController {


    @GetMapping("/index")
    public String index(){
        return "hello i am index";
    }


    @ApiOperation(value = "test role")
    @GetMapping("/checkRole")
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    public String checkRole(){
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.hasRole(role)){
            return "hello, admin";
//        }
//        return "sorry please check your role";
    }

    @ApiOperation(value = "test permission")
    @GetMapping("/checkPermission")
    public String checkPermission(String permission){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isPermitted(permission)){
            return "hello, you have the permission of " + permission;
        }
        return "sorry please check your permission";
    }


    @GetMapping("/unauth")
    public ResultEntity unanth(HttpServletRequest request){
        String path = request.getRequestURI();
        return new ResultEntity(399, "尚未登录", null);
    }


    @GetMapping("/403")
    public ResultEntity forbidden(){
        return new ResultEntity(398,"forbidden", null);
    }

}
