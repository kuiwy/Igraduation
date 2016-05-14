package org.wyk.core;

import android.content.Context;

import com.wyk.model.QuestionObj;

import org.wyk.api.Api;
import org.wyk.api.Service;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by wyk on 2016/5/9.
 */
public class GroupQuestionController {
    private Api api;
    private GroupQuestionCallBack callBack;

    public GroupQuestionController(Context context) {
        api = new Service().getAPI();
        callBack = (GroupQuestionCallBack) context;
    }

    public void queryGroupQuestion(int id){
        api.getGroupQuestion(id).enqueue(new Callback<List<QuestionObj>>() {
            @Override
            public void onResponse(Response<List<QuestionObj>> response, Retrofit retrofit) {
                callBack.querySuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("查询失败");
            }
        });
    }

    public interface GroupQuestionCallBack {
        void querySuccess(List<QuestionObj> list);

        void failure(String s);
    }
}
