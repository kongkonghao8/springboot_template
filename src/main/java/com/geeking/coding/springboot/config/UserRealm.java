package com.geeking.coding.springboot.config;

import com.geeking.coding.springboot.entity.SysPermission;
import com.geeking.coding.springboot.entity.SysRole;
import com.geeking.coding.springboot.entity.SysUser;
import com.geeking.coding.springboot.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * User: devils
 * Date: 2018/12/5
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private ShiroService shiroService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        if(user != null){

            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

            Long userId = user.getId();

            List<SysRole> list = shiroService.getRoles(userId);
            for (SysRole role: list){
                authorizationInfo.addRole(role.getRole());
            }

            List<SysPermission> permissions = shiroService.getUserPermissions(userId);
            for (SysPermission permission : permissions) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }

            return authorizationInfo;
        }
        return null;
    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        SysUser user = shiroService.getUserByName(userName);
        if(user != null){
            return new SimpleAuthenticationInfo(user,user.getPassword(),"myRealm");
        }
        return null;
    }
}
