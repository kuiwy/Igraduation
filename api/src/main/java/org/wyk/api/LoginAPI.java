package org.wyk.api;


import com.wyk.model.UserObj;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 *
 *
 * Created by wyk on 2016/4/21.
 */
public interface LoginAPI {
//http://192.168.1.102:8080/test_server/servlet/Servlet?username=wyk123&password=123456";
    @FormUrlEncoded
    @POST("test_server/servlet/Servlet")
    Call<UserObj> login(@Field("username") String username, @Field("password") String password);
}
