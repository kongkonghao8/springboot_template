package com.geeking.coding.springboot.service;

import com.geeking.coding.springboot.entity.SysPermission;
import com.geeking.coding.springboot.entity.SysRole;
import com.geeking.coding.springboot.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * User: devils
 * Date: 2018/12/8
 */
public interface ShiroService {

    /**
     * 根据用户名得到用户对象
     * @param userName
     * @return
     */
    SysUser getUserByName(String userName);

    /**
     * 根据用户ID得到用户权限
     * @param userId
     * @return
     */
    List<SysPermission> getUserPermissions(Long userId);

    /**
     * 根据用户名得到用户所具有的角色
     * @param id
     * @return
     */
    List<SysRole> getRoles(Long id);
}
