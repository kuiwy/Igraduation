package org.wyk.core;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.wyk.model.QuestionObj;

import org.wyk.api.Api;
import org.wyk.api.Service;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 登录控制类
 * Created by wyk on 2016/4/21.
 */
public class RandomQuestionController {

    private Api api;
    private RandomQuestionCallBack callBack;

    public RandomQuestionController(Context context) {
        api = new Service().getAPI();
        callBack = (RandomQuestionCallBack) context;
    }

    public RandomQuestionController(Fragment context) {
        api = new Service().getAPI();
        callBack = (RandomQuestionCallBack) context;
    }

    public void getRandomQuestion() {
        api.getRandomQuestion().enqueue(new Callback<QuestionObj>() {
            @Override
            public void onResponse(Response<QuestionObj> response, Retrofit retrofit) {
                if (response.body() == null || response.body().getId() == -1) {
                    callBack.failure("登录失败");
                } else {
                    callBack.getQuestionSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("登录失败");
            }
        });
    }

    public interface RandomQuestionCallBack {
        void getQuestionSuccess(QuestionObj question);

        void failure(String s);
    }
}
