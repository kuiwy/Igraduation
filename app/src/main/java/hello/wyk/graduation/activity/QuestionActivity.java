package hello.wyk.graduation.activity;

import hello.wyk.graduation.R;

/**
 * Created by wyk on 2016/5/11.
 */
public class QuestionActivity extends BaseActivity {
    @Override
    public int getContentViewId() {
        return R.layout.layout_question;
    }

    @Override
    public void refreshView() {
        setStatusBar();
    }

    @Override
    public void addEvent() {

    }
}
