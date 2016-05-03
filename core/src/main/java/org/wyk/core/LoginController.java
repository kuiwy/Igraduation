package org.wyk.core;

import android.content.Context;
import android.util.Log;

import com.wyk.model.UserObj;

import org.wyk.api.LoginAPI;
import org.wyk.api.LoginService;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 *
 *
 * Created by wyk on 2016/4/21.
 */
public class LoginController {

    private LoginAPI loginAPI;
    private Context mContext;
    private LoginCallBack loginCallBack;

    public LoginController(Context context){
        mContext = context;
        loginAPI = new LoginService().getLoginAPI();
        loginCallBack = (LoginCallBack) context;
    }

    public void login(String username,String password){
        Log.e("go",username);
        loginAPI.login(username,password).enqueue(new Callback<UserObj>() {
            @Override
            public void onResponse(Response<UserObj> response, Retrofit retrofit) {
                if(response.body() == null||response.body().getId()==-1){
                    loginCallBack.loginFailure("登录失败");
                }else {
                    loginCallBack.loginSuccess(response.body().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("login_failure",t.toString());
            }
        });
    }

    public interface LoginCallBack{
        public void loginSuccess(String s);
        public void loginFailure(String s);
    }

}
