package hello.wyk.graduation.fragment;


import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.wyk.model.GroupObj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.activity.GroupQuestionActivity;
import hello.wyk.graduation.adapter.GroupAdapter;

/**
 * GroupItemViewPager
 * <p/>
 * Created by wyk on 2015/11/23.
 */
public class GroupItemFragment extends BaseFragment {


    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;
    private GroupAdapter groupAdapter;
    private List<GroupObj> list;

    public static BaseFragment newInstance(ArrayList<GroupObj> list) {
        GroupItemFragment fragment = new GroupItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", list);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_1;
    }

    @Override
    protected void findView() {

    }

    @Override
    public void refreshView() {
        list = (List<GroupObj>) getArguments().getSerializable("list");
        if (list != null) {
            groupAdapter = new GroupAdapter(mActivity, list);
            listView.setAdapter(groupAdapter);

        }
    }

    @OnItemClick(R.id.list_view)
    void OnItemClick(int position) {
        mActivity.goActivity(GroupQuestionActivity.class,list.get(position).getGroupid()+"");
    }

    @Override
    public void addEvent() {

    }
}
