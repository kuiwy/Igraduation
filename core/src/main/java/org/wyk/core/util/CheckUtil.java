package org.wyk.core.util;

/**
 * Created by wyk on 2016/5/4.
 */
public class CheckUtil {

    public static boolean isUsername(String username){
        if(username.length()>5&&username.length()<17){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPassword(String password){
        if(password.length()>5&&password.length()<17){
            return true;
        } else {
            return false;
        }
    }
}
