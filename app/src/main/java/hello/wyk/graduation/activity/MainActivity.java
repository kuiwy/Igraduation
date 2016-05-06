package hello.wyk.graduation.activity;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;
import com.wyk.model.UserObj;

import org.wyk.core.Common;
import org.wyk.core.LoginController;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.LeftMenuAdapter;
import hello.wyk.graduation.fragment.MainFragment;
import hello.wyk.graduation.util.DialogUtils;
import hello.wyk.graduation.util.ItemDataUtils;
import hello.wyk.graduation.widget.DragLayout;
import hello.wyk.graduation.widget.RoundAngleImageView;


public class MainActivity extends BaseActivity implements View.OnClickListener, LoginController.LoginCallBack {

    @BindView(R.id.iv_bottom)
    RoundAngleImageView ivBottom;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.iv_icon)
    RoundAngleImageView ivIcon;
    @BindView(R.id.dl)
    DragLayout dl;
    @BindView(R.id.fl_content)
    FrameLayout flContent;

    LeftMenuAdapter leftMenuAdapter;
    LoginController loginController;


    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void refreshView() {
        loginController = new LoginController(this);
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

    @OnClick({R.id.layout_head, R.id.iv_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_head:
                if(Common.userObj==null)
                    login();
                break;
            case R.id.iv_icon:
                dl.open();
        }
    }


    @OnItemClick(R.id.lv)
    void OnItemClick(int position) {
        if(Common.userObj==null&&position!=0){
            login();
            return;
        }
        showToast(position+"");
    }

    private void login() {
        DialogUtils.loginDialog(this, new DialogUtils.DialogCallBack<HashMap<String, String>>() {
            @Override
            public void onPositiveButton(HashMap<String, String> map) {
                super.onPositiveButton(map);
                loginController.login(map.get("username"), map.get("password"));
            }
        });
    }

    @Override
    public void loginSuccess() {
        Snackbar.make(flContent, "欢迎回来，" + Common.userObj.getName(), Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void loginFailure(String s) {
        Snackbar.make(flContent, s, Snackbar.LENGTH_LONG)
                .setAction("重新登录", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login();
                    }
                })
                .show();
    }

}
