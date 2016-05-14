package hello.wyk.graduation.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wyk.model.QuestionObj;

import butterknife.BindView;
import butterknife.OnClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.widget.SmoothCheckBox;

/**
 * Created by wyk on 2016/5/13.
 */
public class QuestionFragment extends BaseFragment {

    QuestionObj question;
    @BindView(R.id.text_question)
    TextView textQuestion;
    @BindView(R.id.check_box)
    SmoothCheckBox checkBoxA;
    @BindView(R.id.ans_a)
    TextView ansA;
    @BindView(R.id.layout_a)
    LinearLayout layoutA;
    @BindView(R.id.check_box_b)
    SmoothCheckBox checkBoxB;
    @BindView(R.id.ans_b)
    TextView ansB;
    @BindView(R.id.layout_b)
    LinearLayout layoutB;
    @BindView(R.id.check_box_c)
    SmoothCheckBox checkBoxC;
    @BindView(R.id.ans_c)
    TextView ansC;
    @BindView(R.id.layout_c)
    LinearLayout layoutC;
    @BindView(R.id.check_box_d)
    SmoothCheckBox checkBoxD;
    @BindView(R.id.ans_d)
    TextView ansD;
    @BindView(R.id.layout_d)
    LinearLayout layoutD;
    @BindView(R.id.ans_you)
    TextView ansYou;
    @BindView(R.id.ans)
    TextView ans;
    @BindView(R.id.layout_ans)
    LinearLayout layoutAns;

    @Override
    public int getViewId() {
        return R.layout.fragment_question;
    }

    public static BaseFragment newInstance(QuestionObj question) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", question);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void refreshView() {
        question = (QuestionObj) getArguments().getSerializable("question");
        refresh();
    }

    private void refresh() {
        if (question != null) {
            textQuestion.setText(question.getTitle());
            ansA.setText(question.getAnsa());
            ansB.setText(question.getAnsb());
            ansC.setText(question.getAnsc());
            ansD.setText(question.getAnsd());
            layoutA.setClickable(true);
            layoutB.setClickable(true);
            layoutB.setClickable(true);
            layoutB.setClickable(true);
            checkBoxA.setClickable(false);
            checkBoxB.setClickable(false);
            checkBoxC.setClickable(false);
            checkBoxD.setClickable(false);
            checkBoxA.setChecked(false);
            checkBoxB.setChecked(false);
            checkBoxC.setChecked(false);
            checkBoxD.setChecked(false);
            layoutAns.setVisibility(View.GONE);
        }
    }

    @Override
    public void addEvent() {

    }

    @OnClick({R.id.layout_a, R.id.layout_b, R.id.layout_c, R.id.layout_d})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_a:
                checkBoxA.setChecked(true);
                checkAns = "1";
                check();
                break;
            case R.id.layout_b:
                checkBoxB.setChecked(true);
                checkAns = "2";
                check();
                break;
            case R.id.layout_c:
                checkBoxC.setChecked(true);
                checkAns = "3";
                check();
                break;
            case R.id.layout_d:
                checkBoxD.setChecked(true);
                checkAns = "4";
                check();
                break;
        }
    }
    private String checkAns;
    public void check(){
        layoutAns.setVisibility(View.VISIBLE);
        ans.setText(question.getAns());
        ansYou.setText(checkAns);
        if(!checkAns.equals(question.getAns())){
            ansYou.setTextColor(Color.RED);
        } else {
            ansYou.setTextColor(Color.GREEN);
        }
        layoutA.setClickable(false);
        layoutB.setClickable(false);
        layoutC.setClickable(false);
        layoutD.setClickable(false);
        checkBoxA.setClickable(false);
        checkBoxB.setClickable(false);
        checkBoxC.setClickable(false);
        checkBoxD.setClickable(false);
    }

}
