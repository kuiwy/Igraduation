package org.wyk.api;


import com.squareup.okhttp.RequestBody;
import com.wyk.model.ArticleObj;
import com.wyk.model.GroupObj;
import com.wyk.model.QuestionObj;
import com.wyk.model.UserObj;

import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * 接口uri
 * Created by wyk on 2016/4/21.
 */
public interface Api {
    //http://192.168.1.102:8080/test_server/servlet/Servlet?username=wyk123&password=123456";
    @FormUrlEncoded
    @POST("wyk/login")
    Call<UserObj> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("wyk/login")
    Call<UserObj> register(@Field("username") String username, @Field("password") String password, @Field("nickname") String nickname);

    @FormUrlEncoded
    @POST("wyk/queryUserInfo")
    Call<UserObj> queryUserInfo(@Field("id") int id);

    @FormUrlEncoded
    @POST("wyk/editUserInfo")
    Call<String> editUserInfo(@FieldMap Map<String, String> map);

    @Multipart
    @POST("/wyk/uploadPic")
    Call<String> uploadImage(@Part("username") String username, @Part("file\"; filename=\"image.png\"") RequestBody img);

    @FormUrlEncoded
    @POST("wyk/getArticleList")
    Call<List<ArticleObj>> getArticleList(@Field("offset") int offset);

    @POST("wyk/getRandomQuestion")
    Call<QuestionObj> getRandomQuestion();

    @POST("wyk/queryGroup")
    Call<List<GroupObj>> getGroup();

    @FormUrlEncoded
    @POST("wyk/getGroupQuestion")
    Call<List<QuestionObj>> getGroupQuestion(@Field("id") int id);

}
