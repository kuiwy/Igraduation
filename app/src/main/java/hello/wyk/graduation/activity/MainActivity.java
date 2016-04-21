package hello.wyk.graduation.activity;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.nineoldandroids.view.ViewHelper;

import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.LeftMenuAdapter;
import hello.wyk.graduation.fragment.MainFragment;
import hello.wyk.graduation.util.ItemDataUtils;
import hello.wyk.graduation.widget.DragLayout;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private DragLayout dl;
    private ListView lv;
    private LeftMenuAdapter leftMenuAdapter;
    private ImageView iv_icon, iv_bottom;



    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    public void findView() {
        dl = (DragLayout) findViewById(R.id.dl);
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        iv_bottom = (ImageView) findViewById(R.id.iv_bottom);
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void refreshView() {
        setStatusBar();
        leftMenuAdapter = new LeftMenuAdapter(this, ItemDataUtils.getItemBeans());
        lv.setAdapter(leftMenuAdapter);
        FrameLayout fl_content = (FrameLayout) findViewById(R.id.fl_content);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fl_content.getId(), new MainFragment()).commit();
    }

    @Override
    public void addEvent() {
        iv_icon.setOnClickListener(this);
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
                ViewHelper.setAlpha(iv_icon, 1 - percent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_icon:
                dl.open();
                break;
            default:
                break;
        }
    }
}
