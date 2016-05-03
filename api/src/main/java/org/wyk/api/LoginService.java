package org.wyk.api;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 *
 * Created by wyk on 2016/4/21.
 */
public class LoginService {

    public final String baseUrl = "http://121.42.218.11:8080/";
    private Retrofit retrofit;

    public LoginService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public LoginAPI getLoginAPI() {
        return retrofit.create(LoginAPI.class);
    }
}
