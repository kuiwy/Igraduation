package org.wyk.core;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.wyk.model.UserObj;

import org.wyk.api.Api;
import org.wyk.api.Service;
import org.wyk.core.util.Common;

import java.io.File;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by wyk on 2016/5/9.
 */
public class UserInfoController {
    private Api api;
    private UserInfoCallBack callBack;

    public UserInfoController(Context context) {
        api = new Service().getAPI();
        callBack = (UserInfoCallBack) context;
    }

    public void queryUserInfo(int id){
        api.queryUserInfo(id).enqueue(new Callback<UserObj>() {
            @Override
            public void onResponse(Response<UserObj> response, Retrofit retrofit) {
                Common.userObj = response.body();
                callBack.querySuccess();
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("查询失败");
            }
        });
    }

    public void editUserInfo(Map<String,String> map){
        map.put("id", Common.userObj.getId()+"");
        api.editUserInfo(map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                Log.e("wyk_editUserInfo",response.body());
                callBack.editSuccess();
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("查询失败");
            }
        });
    }

    public void uploadPic(String fileUrl){
        RequestBody requestBody  = RequestBody.create(MediaType.parse("multipart/form-data"),new File(fileUrl));
        api.uploadImage(Common.userObj.getUsername(),requestBody).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                callBack.editSuccess();
                Log.e("wyk", "success");
                if(response.body()!=null){
                    Log.e("wyk", response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }

    public interface UserInfoCallBack {
        void editSuccess();

        void querySuccess();

        void failure(String s);
    }
}
