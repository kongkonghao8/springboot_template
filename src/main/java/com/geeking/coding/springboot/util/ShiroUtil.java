package com.geeking.coding.springboot.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * User: devils
 * Date: 2018/12/5
 */
public class ShiroUtil {

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

}
