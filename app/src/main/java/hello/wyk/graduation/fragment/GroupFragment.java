package hello.wyk.graduation.fragment;


import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import hello.wyk.graduation.adapter.MyPagerAdapter;
import hello.wyk.graduation.R;

/**
 * 主页第二个Fragment
 *
 * Created by wyk on 2015/11/23.
 */
public class GroupFragment extends BaseFragment {

    private ViewPager mViewPager;
    private PagerTabStrip mViewPagerStrip;

    @Override
    public int getViewId() {
        return R.layout.fragment_2;
    }

    @Override
    protected void findView() {
        mViewPager = (ViewPager) mView.findViewById(R.id.viewpager);
        mViewPagerStrip = (PagerTabStrip) mView.findViewById(R.id.viewpager_strip);
    }

    @Override
    public void refreshView() {
        final int highlightColor = getResources().getColor(R.color.holo_secondary);
        mViewPagerStrip = (PagerTabStrip) mView.findViewById(R.id.viewpager_strip);
        mViewPagerStrip.setBackgroundResource(R.color.background_secondary);
        mViewPagerStrip.setNonPrimaryAlpha(0.4f);
        mViewPagerStrip.setDrawFullUnderline(false);
        mViewPagerStrip.setTabIndicatorColor(highlightColor);
        mViewPagerStrip.setTextColor(highlightColor);

        MyPagerAdapter mPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),getActivity());
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void addEvent() {

    }
}
