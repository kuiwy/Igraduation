package hello.wyk.graduation.activity;

import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyk.model.QuestionObj;

import org.wyk.core.GroupQuestionController;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.GroupQuestionPagerAdapter;

/**
 * Created by wyk on 2016/5/13.
 */
public class GroupQuestionActivity extends BaseActivity implements GroupQuestionController.GroupQuestionCallBack {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.text_group_name)
    TextView textGroupName;

    GroupQuestionPagerAdapter adapter;
    GroupQuestionController controller;

    @Override
    public int getContentViewId() {
        return R.layout.activity_group_question;
    }

    @Override
    public void refreshView() {
        setStatusBar();
        String id = getInActivityStrValue();
        controller = new GroupQuestionController(this);
        controller.queryGroupQuestion(Integer.parseInt(id));
        viewPager.setOffscreenPageLimit(20);
    }

    @Override
    public void addEvent() {

    }

    @Override
    public void querySuccess(List<QuestionObj> list) {
        textGroupName.setText(list.get(0).getGroupname());
        adapter = new GroupQuestionPagerAdapter(getSupportFragmentManager(), this, list);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void failure(String s) {
        Snackbar.make(viewPager, s, Snackbar.LENGTH_LONG)
                .show();
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
    }
}
