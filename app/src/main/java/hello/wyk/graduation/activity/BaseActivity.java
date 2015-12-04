package hello.wyk.graduation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.Serializable;

import hello.wyk.graduation.util.AppManager;

/**
 * 所有Activity的基类
 *
 * Created by wyk on 2015/12/3.
 */
public abstract class BaseActivity extends FragmentActivity {
    /**
     * 布局Id(xml文件)
     *
     * @return LayoutID
     */
    public abstract int getContentViewId();

    /**
     * 初始化布局文件的View
     */
    protected abstract void findView();

    /**
     * 初始化View
     */
    public abstract void refreshView();

    /**
     * 为View 添加事件
     */
    public abstract void addEvent();

    /**
     * 在setContentView之前的操作
     */
    public void setViewBefore() {

    }

    protected String TAG;
    protected Context mContext;
    protected Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = this.getClass().getName();
        super.onCreate(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        setViewBefore();
        setContentView(getContentViewId());
        findView();
        refreshView();
        addEvent();
    }

    public void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_LONG);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 根据string.xml中的id获取字符串
     *
     * @param resId 资源id
     * @return String
     */
    protected String getResString(int resId) {
        return getResources().getString(resId);
    }

    public void finishSec() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

    /**
     * 隐藏键盘
     */
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        //noinspection ConstantConditions
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     */
    public void goActivity(Class<?> cls) {
        goActivity(cls, null, null, 0);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param value 携带的Serializable数据
     */
    public void goActivity(Class<?> cls, Serializable value) {
        goActivity(cls, null, value, 0);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param value 携带的Serializable数据
     * @param requestCode 请求码
     */
    public void goActivity(Class<?> cls, Serializable value, int requestCode) {
        goActivity(cls, null, value, requestCode);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param value 携带的String数据
     */
    public void goActivity(Class<?> cls, String value) {
        goActivity(cls, value, null, 0);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param value 携带的String数据
     * @param requestCode 请求码
     */
    public void goActivity(Class<?> cls, String value, int requestCode) {
        goActivity(cls, value, null, requestCode);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param strValue 携带的String数据
     * @param serValue 携带的Serializable数据
     */
    public void goActivity(Class<?> cls, String strValue, Serializable serValue) {
        goActivity(cls, strValue, serValue, 0);
    }

    /**
     *
     * @param cls 跳转到的下一个Activity
     * @param strValue 携带的String数据
     * @param serValue 携带的Serializable数据
     * @param requestCode 请求码，不能为0
     */
    public void goActivity(Class<?> cls, String strValue,
                           Serializable serValue, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (strValue != null)
            intent.putExtra("putStrValue", strValue);
        if (serValue != null)
            intent.putExtra("putSerValue", serValue);
        if (requestCode == 0) {
            startActivity(intent);
        } else {
            startActivityForResult(intent, requestCode);
        }
    }

    /**
     * 获得上个Activity传来的Serializable数据
     * @return Serializable
     */
    public Serializable getInActivitySerValue() {
        Intent intent = getIntent();
        return intent.getSerializableExtra("putSerValue");
    }
    /**
     * 获得上个Activity传来的String数据
     * @return String
     */
    public String getInActivityStrValue() {
        Intent intent = getIntent();
        return intent.getStringExtra("putStrValue");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }
}
