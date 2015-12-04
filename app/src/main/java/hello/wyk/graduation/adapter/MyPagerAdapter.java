package hello.wyk.graduation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hello.wyk.graduation.fragment.BaseFragment;
import hello.wyk.graduation.fragment.MyFragment1;

/**
 * ViewPager适配器
 *
 * Created by wyk on 2015/12/3.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private static final String[] title = {"JAVA","C/C++","数据结构","算法","计算机基础","移动开发"};

    private static String getTitle(int position){
        return title[position];
    }

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        final BaseFragment fragment;
        switch (position) {
            case 0:
                fragment = new MyFragment1();
                break;
            case 1:
                fragment = new MyFragment1();
                break;
            case 2:
                fragment = new MyFragment1();
                break;
            case 3:
                fragment = new MyFragment1();
                break;
            case 4:
                fragment = new MyFragment1();
                break;
            case 5:
                fragment = new MyFragment1();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MyPagerAdapter.getTitle(position);
    }
}
