package hello.wyk.graduation.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;

import org.wyk.core.LoginController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.LeftMenuAdapter;
import hello.wyk.graduation.fragment.MainFragment;
import hello.wyk.graduation.util.ItemDataUtils;
import hello.wyk.graduation.widget.DragLayout;
import hello.wyk.graduation.widget.RoundAngleImageView;


public class MainActivity extends BaseActivity implements View.OnClickListener, LoginController.LoginCallBack {

    @BindView(R.id.iv_bottom)
    private RoundAngleImageView ivBottom;
    @BindView(R.id.lv)
    private ListView lv;
    @BindView(R.id.iv_icon)
    private RoundAngleImageView ivIcon;
    @BindView(R.id.dl)
    private DragLayout dl;
    @BindView(R.id.fl_content)
    private FrameLayout flContent;

    private LeftMenuAdapter leftMenuAdapter;


    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void refreshView() {
        setStatusBar();
        leftMenuAdapter = new LeftMenuAdapter(this, ItemDataUtils.getItemBeans());
        lv.setAdapter(leftMenuAdapter);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(flContent.getId(), new MainFragment()).commit();
    }

    @Override
    public void addEvent() {
        initDragLayout();
    }

    private void initDragLayout() {
        dl.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {
            }

            //界面关闭的时候
            @Override
            public void onClose() {
            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(ivIcon, 1 - percent);
            }
        });
    }

    @OnClick({R.id.iv_bottom, R.id.iv_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_bottom:
                break;
            case R.id.iv_icon:
                break;
        }
    }

    @Override
    public void loginSuccess(String s) {
        Toast.makeText(this, "登录成功  " + s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}
