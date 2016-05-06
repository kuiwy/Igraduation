package org.wyk.core;

import android.content.Context;
import android.util.Log;

import com.wyk.model.UserObj;

import org.wyk.api.LoginAPI;
import org.wyk.api.LoginService;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 登录控制类
 * Created by wyk on 2016/4/21.
 */
public class LoginController {

    private LoginAPI loginAPI;
    private LoginCallBack loginCallBack;

    public LoginController(Context context) {
        loginAPI = new LoginService().getLoginAPI();
        loginCallBack = (LoginCallBack) context;
    }

    public void login(String username, String password) {
        loginAPI.login(username, password).enqueue(new Callback<UserObj>() {
            @Override
            public void onResponse(Response<UserObj> response, Retrofit retrofit) {
                if (response.body() == null || response.body().getId() == -1) {
                    loginCallBack.loginFailure("登录失败");
                } else {
                    Common.userObj = response.body();
                    loginCallBack.loginSuccess();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                loginCallBack.loginFailure("登录失败");
            }
        });
    }

    public interface LoginCallBack {
        void loginSuccess();

        void loginFailure(String s);
    }

}
