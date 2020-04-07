package com.geeking.coding.springboot.entity;

import java.io.Serializable;

/**
 * User: devils
 * Date: 2018/12/5
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 6087390377908226791L;

    private Long id;

    private Long userId;

    private String role;

    private String createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
