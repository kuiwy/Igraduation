package hello.wyk.graduation.fragment;


import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.wyk.model.GroupObj;

import org.wyk.core.GroupController;
import org.wyk.core.GroupController.GroupCallBack;

import java.util.List;

import butterknife.BindView;
import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.GroupPagerAdapter;

/**
 * 展示所有分组
 * Created by wyk on 2015/11/23.
 */
public class GroupFragment extends BaseFragment implements GroupCallBack {


    @BindView(R.id.viewpager_strip)
    PagerTabStrip viewpagerStrip;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    GroupController groupController;

    @Override
    public int getViewId() {
        return R.layout.fragment_group;
    }


    @Override
    public void refreshView() {
        groupController = new GroupController(this);
        groupController.getGroup();
        final int highlightColor = getResources().getColor(R.color.holo_secondary);
        viewpagerStrip = (PagerTabStrip) mView.findViewById(R.id.viewpager_strip);
        viewpagerStrip.setBackgroundResource(R.color.background_secondary);
        viewpagerStrip.setNonPrimaryAlpha(0.4f);
        viewpagerStrip.setDrawFullUnderline(false);
        viewpagerStrip.setTabIndicatorColor(highlightColor);
        viewpagerStrip.setTextColor(highlightColor);

    }

    @Override
    public void addEvent() {

    }

    @Override
    public void success(List<GroupObj> list) {
        GroupPagerAdapter mPagerAdapter = new GroupPagerAdapter(getChildFragmentManager(), getActivity(),list);
        viewpager.setAdapter(mPagerAdapter);
    }

    @Override
    public void failure(String s) {
        Snackbar.make(contentFrame, s, Snackbar.LENGTH_LONG)
                .setAction("重新获取", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        groupController.getGroup();
                    }
                })
                .show();
    }
}
