package com.geeking.coding.springboot.entity;

import java.io.Serializable;

/**
 * User: devils
 * Date: 2018/12/5
 */
public class SysPermission implements Serializable{

    private static final long serialVersionUID = 8502683797828642029L;

    private Long id;

    private String permission;

    private Long userId;

    private String createDate;


    public SysPermission(Long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
