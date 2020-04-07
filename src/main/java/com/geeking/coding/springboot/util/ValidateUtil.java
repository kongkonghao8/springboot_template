package com.geeking.coding.springboot.util;

/**
 * User: devils
 * Date: 2018/12/8
 */
public class ValidateUtil {

    private static final String TELPHONE_REGEX = "^[1][3,4,5,7,8,9][0-9]{9}$";

    private static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";


    /**
     * 验证手机号是否正确
     * @param telphone
     * @return
     */
    public static boolean isPhone(String telphone){
        if(telphone == null){
            return false;
        }
        return telphone.matches(TELPHONE_REGEX);
    }

    /**
     * 验证邮箱是否正确
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if("".equals(email) || email == null){
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }

}
