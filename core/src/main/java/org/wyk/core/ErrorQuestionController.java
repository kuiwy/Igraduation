package org.wyk.core;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.wyk.model.ArticleObj;
import com.wyk.model.QuestionObj;
import com.wyk.model.UserObj;

import org.wyk.api.Api;
import org.wyk.api.Service;
import org.wyk.core.util.Common;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by wyk on 2016/5/17.
 */
public class ErrorQuestionController {
    private Api api;
    private ErrorQuestionCallBack callBack;

    public ErrorQuestionController() {
        api = new Service().getAPI();
    }
    public ErrorQuestionController(Context context) {
        api = new Service().getAPI();
        callBack = (ErrorQuestionCallBack) context;
    }

    public ErrorQuestionController(Fragment fragment) {
        api = new Service().getAPI();
        callBack = (ErrorQuestionCallBack) fragment;
    }

    public void queryErrorQuestion() {
        api.queryErrorQuestion(Common.userObj.getId()).enqueue(new Callback<List<QuestionObj>>() {
            @Override
            public void onResponse(Response<List<QuestionObj>> response, Retrofit retrofit) {
                callBack.success(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("拉取列表失败");
            }
        });
    }

    public void upLoadErrorQuestion(int questionid){
        api.updateErrorQuestion(Common.userObj.getId(),questionid).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public interface ErrorQuestionCallBack {
        void success(List<QuestionObj> list);

        void failure(String s);
    }
}
