package hello.wyk.graduation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wyk.model.QuestionObj;

import java.util.List;

import hello.wyk.graduation.fragment.BaseFragment;
import hello.wyk.graduation.fragment.QuestionFragment;

/**
 * ViewPager适配器
 * <p/>
 * Created by wyk on 2015/12/3.
 */
public class GroupQuestionPagerAdapter extends FragmentPagerAdapter {

    private List<QuestionObj> list;
    private Context mContext;

    public GroupQuestionPagerAdapter(FragmentManager fm, Context context, List<QuestionObj> list) {
        super(fm);
        mContext = context;
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        final BaseFragment fragment;
        fragment = QuestionFragment.newInstance(list.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
