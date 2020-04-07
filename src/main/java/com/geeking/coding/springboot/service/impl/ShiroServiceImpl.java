package com.geeking.coding.springboot.service.impl;

import com.geeking.coding.springboot.dao.ShiroMapper;
import com.geeking.coding.springboot.dao.UserMapper;
import com.geeking.coding.springboot.entity.SysPermission;
import com.geeking.coding.springboot.entity.SysRole;
import com.geeking.coding.springboot.entity.SysUser;
import com.geeking.coding.springboot.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: devils
 * Date: 2018/12/5
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroMapper shiroMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public List<SysPermission> getUserPermissions(Long userId) {
        return shiroMapper.listPermissionsByUid(userId);
    }

    @Override
    public List<SysRole> getRoles(Long userId) {
        return shiroMapper.listRolesByUid(userId);
    }
}
