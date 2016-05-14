package org.wyk.core;

import android.content.Context;

import com.wyk.model.UserObj;

import org.wyk.api.Api;
import org.wyk.api.Service;
import org.wyk.core.util.Common;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 登录控制类
 * Created by wyk on 2016/4/21.
 */
public class LoginRegisterController {

    private Api api;
    private LoginCallBack loginCallBack;
    private RegisterCallBack registerCallBack;

    public LoginRegisterController(Context context) {
        api = new Service().getAPI();
        loginCallBack = (LoginCallBack) context;
        registerCallBack = (RegisterCallBack) context;
    }

    public void login(String username, String password) {
        api.login(username, password).enqueue(new Callback<UserObj>() {
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

    public void register(String username, String password,String nickname) {
        api.register(username, password,nickname).enqueue(new Callback<UserObj>() {
            @Override
            public void onResponse(Response<UserObj> response, Retrofit retrofit) {
                if (response.body() == null || response.body().getId() == -1) {
                    registerCallBack.registerFailure("用户名已存在");
                } else {
                    Common.userObj = response.body();
                    registerCallBack.registerSuccess();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                registerCallBack.registerFailure("注册失败，位置原因");
            }
        });
    }

    public interface LoginCallBack {
        void loginSuccess();

        void loginFailure(String s);
    }

    public interface RegisterCallBack {
        void registerSuccess();

        void registerFailure(String s);
    }

}
