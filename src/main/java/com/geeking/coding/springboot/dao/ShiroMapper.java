package com.geeking.coding.springboot.dao;

import com.geeking.coding.springboot.entity.SysPermission;
import com.geeking.coding.springboot.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User: devils
 * Date: 2018/12/8
 */
@Mapper
public interface ShiroMapper {

    List<SysRole> listRolesByUid(Long userId);

    List<SysPermission> listPermissionsByUid(Long uid);

}
