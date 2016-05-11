package org.wyk.api;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 *
 * Created by wyk on 2016/4/21.
 */
public class Service {

    private Retrofit retrofit;

    public Service() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Api getAPI() {
        return retrofit.create(Api.class);
    }
}
