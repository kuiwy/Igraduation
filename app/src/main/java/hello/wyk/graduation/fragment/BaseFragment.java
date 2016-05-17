package hello.wyk.graduation.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import hello.wyk.graduation.activity.BaseActivity;

/**
 * 所有Fragment的基类
 * Created by wyk on 2015/12/3.
 */
public abstract class BaseFragment extends Fragment {
    protected View mView;
    protected BaseActivity mActivity;

    /**
     * Fragment布局Id(xml文件)
     *
     * @return LayoutID
     */
    public abstract int getViewId();

    /**
     * 初始化布局文件的View
     */
    protected void findView(){}

    /**
     * 初始化View
     */
    public abstract void refreshView();

    /**
     * 为View 添加事件
     */
    public abstract void addEvent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getViewId(), container, false);
        ButterKnife.bind(this, mView);
        findView();
        refreshView();
        addEvent();
        return mView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }
}
