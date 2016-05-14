package hello.wyk.graduation.activity;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wyk.model.QuestionObj;

import org.wyk.core.RandomQuestionController;

import butterknife.BindView;
import butterknife.OnClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.widget.SmoothCheckBox;

/**
 * Created by wyk on 2016/5/11.
 */
public class QuestionActivity extends BaseActivity implements RandomQuestionController.RandomQuestionCallBack {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
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
    @BindView(R.id.btn_change)
    TextView btnChange;

    RandomQuestionController randomQuestionController;
    private String checkAns;
    private QuestionObj questionObj;

    @Override
    public int getContentViewId() {
        return R.layout.layout_question;
    }

    @Override
    public void refreshView() {
        setStatusBar();
        randomQuestionController = new RandomQuestionController(this);
        randomQuestionController.getRandomQuestion();
        btnChange.setClickable(false);
    }

    @Override
    public void addEvent() {

    }

    @OnClick({R.id.iv_back, R.id.layout_a, R.id.layout_b, R.id.layout_c, R.id.layout_d, R.id.btn_change})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
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
            case R.id.btn_change:
                randomQuestionController.getRandomQuestion();
                btnChange.setClickable(false);
                break;
        }
    }

    public void check(){
        layoutAns.setVisibility(View.VISIBLE);
        ans.setText(questionObj.getAns());
        ansYou.setText(checkAns);
        if(!checkAns.equals(questionObj.getAns())){
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

    public void refresh(QuestionObj question){
        SpannableStringBuilder builder = new SpannableStringBuilder(question.getStringType()+question.getTitle());
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLUE);
        builder.setSpan(redSpan, 0, question.getStringType().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textQuestion.setText(builder);
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

    @Override
    public void getQuestionSuccess(QuestionObj question) {
        questionObj = question;
        btnChange.setClickable(true);
        refresh(question);
    }

    @Override
    public void failure(String s) {
        btnChange.setClickable(true);
    }
}
