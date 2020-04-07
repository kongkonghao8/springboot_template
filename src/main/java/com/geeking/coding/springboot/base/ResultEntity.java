package com.geeking.coding.springboot.base;

import com.geeking.coding.springboot.entity.SysUser;

import java.io.Serializable;

/**
 * User: devils
 * Date: 2018/12/5
 */
public class ResultEntity implements Serializable{

    private static final long serialVersionUID = -3537195608665160814L;

    private Integer code;

    private String message;

    private Object data;

    public ResultEntity(int code, String message, SysUser data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
