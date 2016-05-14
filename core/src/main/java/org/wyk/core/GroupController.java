package org.wyk.core;

import android.support.v4.app.Fragment;

import com.wyk.model.GroupObj;

import org.wyk.api.Api;
import org.wyk.api.Service;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by wyk on 2016/5/13.
 */
public class GroupController {
    private Api api;
    private GroupCallBack callBack;

    public GroupController(Fragment fragment) {
        api = new Service().getAPI();
        callBack = (GroupCallBack) fragment;
    }

    public void getGroup(){
        api.getGroup().enqueue(new Callback<List<GroupObj>>() {
            @Override
            public void onResponse(Response<List<GroupObj>> response, Retrofit retrofit) {
                if(response.body()!=null)
                    callBack.success(response.body());
                else
                    callBack.failure("获取失败");
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.failure("获取失败");
            }
        });
    }

    public interface GroupCallBack {
        void success(List<GroupObj> list);

        void failure(String s);
    }

}
