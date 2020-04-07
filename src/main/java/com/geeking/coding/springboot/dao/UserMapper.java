package com.geeking.coding.springboot.dao;

import com.geeking.coding.springboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * User: devils
 * Date: 2018/12/6
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    SysUser findUserByName(String name);
}
