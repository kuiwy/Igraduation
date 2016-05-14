package hello.wyk.graduation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wyk.model.GroupObj;

import java.util.ArrayList;
import java.util.List;

import hello.wyk.graduation.fragment.BaseFragment;
import hello.wyk.graduation.fragment.GroupItemFragment;

/**
 * ViewPager适配器
 * <p/>
 * Created by wyk on 2015/12/3.
 */
public class GroupPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private static final String[] title = {"C/C++", "JAVA", "数据结构", "计算机基础"};
    private ArrayList<GroupObj> list1;
    private ArrayList<GroupObj> list2;
    private ArrayList<GroupObj> list3;
    private ArrayList<GroupObj> list4;

    private static String getTitle(int position) {
        return title[position];
    }

    public GroupPagerAdapter(FragmentManager fm, Context context, List<GroupObj> list) {
        super(fm);
        mContext = context;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i).getType()) {
                case 1:
                    list1.add(list.get(i));
                    break;
                case 2:
                    list2.add(list.get(i));
                    break;
                case 3:
                    list3.add(list.get(i));
                    break;
                case 4:
                    list4.add(list.get(i));
                    break;
            }
        }
    }


    @Override
    public Fragment getItem(int position) {
        final BaseFragment fragment;
        switch (position) {
            case 0:
                fragment = GroupItemFragment.newInstance(list1);
                break;
            case 1:
                fragment = GroupItemFragment.newInstance(list2);
                break;
            case 2:
                fragment = GroupItemFragment.newInstance(list3);
                break;
            case 3:
                fragment = GroupItemFragment.newInstance(list4);
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return GroupPagerAdapter.getTitle(position);
    }
}
