package hello.wyk.graduation.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import hello.wyk.graduation.fragment.MyFragment1;
import hello.wyk.graduation.fragment.MyFragment2;
import hello.wyk.graduation.fragment.MyFragment3;
import hello.wyk.graduation.R;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    FrameLayout fl_content;
    Fragment fromF;
    TextView tv_menu1,tv_menu2,tv_menu3;
    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    public void findView() {
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        tv_menu1 = (TextView) findViewById(R.id.tv_menu1);
        tv_menu2 = (TextView) findViewById(R.id.tv_menu2);
        tv_menu3 = (TextView) findViewById(R.id.tv_menu3);
        tv_menu1.setOnClickListener(this);
        tv_menu2.setOnClickListener(this);
        tv_menu3.setOnClickListener(this);
    }

    @Override
    public void refreshView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (myFragment1 == null && fl_content != null) {
            myFragment1 = new MyFragment1();
        }
        transaction.add(R.id.fl_content, myFragment1);
        fromF = myFragment1;
        transaction.commit();
        tv_menu1.setSelected(true);
    }

    @Override
    public void addEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_menu1:
                tabSelected(1);
                break;
            case R.id.tv_menu2:
                tabSelected(2);
                break;
            case R.id.tv_menu3:
                tabSelected(3);
                break;
            default:
                break;
        }
    }

    private void tabSelected(int position) {
        tv_menu1.setSelected(false);
        tv_menu2.setSelected(false);
        tv_menu3.setSelected(false);
        switch (position) {
            case 1:
                if (myFragment1 == null) {
                    myFragment1 = new MyFragment1();
                }
                switchFragment(myFragment1);
                tv_menu1.setSelected(true);
                break;
            case 2:
                if (myFragment2 == null) {
                    myFragment2 = new MyFragment2();
                }
                switchFragment(myFragment2);
                tv_menu2.setSelected(true);
                break;
            case 3:
                if (myFragment3 == null) {
                    myFragment3 = new MyFragment3();
                }
                switchFragment(myFragment3);
                tv_menu3.setSelected(true);
                break;
            default:
                break;
        }
    }
    private void switchFragment(Fragment f) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!f.isAdded()) {
            transaction.hide(fromF).add(fl_content.getId(), f);
        } else {
            transaction.hide(fromF).show(f);
        }
        transaction.commitAllowingStateLoss();
        fromF = f;
    }
}
