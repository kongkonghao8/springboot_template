package com.geeking.coding.springboot.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * User: devils
 * Date: 2018/12/5
 */
public class SysUser implements Serializable{

    private static final long serialVersionUID = 701980668487426004L;

    private Long id;

    @ApiModelProperty
    private String name;

    @ApiModelProperty
    private String password;

    private String telephone;

    private String email;

    private String alipayAccount;

    private String wxUnionID;

    private String qqNumber;

    private String account;

    private String createTime;

    private String lastLogin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getWxUnionID() {
        return wxUnionID;
    }

    public void setWxUnionID(String wxUnionID) {
        this.wxUnionID = wxUnionID;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", wxUnionID='" + wxUnionID + '\'' +
                ", qqNumber='" + qqNumber + '\'' +
                ", account='" + account + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                '}';
    }
}
