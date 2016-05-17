package hello.wyk.graduation.fragment;

import android.widget.ListView;

import com.wyk.model.QuestionObj;

import org.wyk.core.ErrorQuestionController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.activity.QuestionDetailActivity;
import hello.wyk.graduation.adapter.ErrorQuestionListAdapter;

/**
 *
 * Created by wyk on 2016/5/17.
 */
public class ErrorQuestionFragment extends BaseFragment implements ErrorQuestionController.ErrorQuestionCallBack {
    @BindView(R.id.list_view)
    ListView listView;

    ErrorQuestionListAdapter errorQuestionListAdapter;
    ErrorQuestionController errorQuestionController;
    List<QuestionObj> list;

    @Override
    public int getViewId() {
        return R.layout.fragment_error_question_list;
    }

    @Override
    public void refreshView() {
        errorQuestionController = new ErrorQuestionController(this);
        list = new ArrayList<>();
        errorQuestionListAdapter = new ErrorQuestionListAdapter(mActivity,list);
        listView.setAdapter(errorQuestionListAdapter);
        errorQuestionController.queryErrorQuestion();
    }

    @Override
    public void addEvent() {

    }

    @OnItemClick(R.id.list_view)
    void OnItemClick(int position) {
        mActivity.goActivity(QuestionDetailActivity.class,list.get(position));
    }

    @Override
    public void success(List<QuestionObj> list) {
        this.list.clear();
        this.list.addAll(list);
        errorQuestionListAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(String s) {

    }
}
