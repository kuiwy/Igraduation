package org.wyk.core;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.wyk.model.ArticleObj;

import org.wyk.api.Api;
import org.wyk.api.Service;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 *
 * Created by wyk on 2016/5/9.
 */
public class ArticleController {
    private Api api;
    private ArticleCallBack callBack;

    public ArticleController(Context context) {
        api = new Service().getAPI();
        callBack = (ArticleCallBack) context;
    }

    public ArticleController(Fragment fragment) {
        api = new Service().getAPI();
        callBack = (ArticleCallBack) fragment;
    }

    public void getArticleList(int offset) {
        api.getArticleList(offset).enqueue(new Callback<List<ArticleObj>>() {
            @Override
            public void onResponse(Response<List<ArticleObj>> response, Retrofit retrofit) {
                callBack.success(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("拉取列表失败");
            }
        });
    }

    public interface ArticleCallBack {
        void success(List<ArticleObj> list);

        void failure(String s);
    }
}
