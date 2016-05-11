package hello.wyk.graduation.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.yongchun.library.view.ImageSelectorActivity;

import org.wyk.api.ApiConfig;
import org.wyk.core.UserInfoController;
import org.wyk.core.util.Common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import hello.wyk.graduation.R;
import hello.wyk.graduation.util.DialogUtils;
import hello.wyk.graduation.widget.RoundAngleImageView;

/**
 * 用户信息界面
 * Created by wyk on 2016/5/9.
 */
public class UserInfoActivity extends BaseActivity implements UserInfoController.UserInfoCallBack, DatePickerDialog.OnDateSetListener {
    @BindView(R.id.iv_head)
    RoundAngleImageView ivHead;
    @BindView(R.id.text_nickname_value)
    TextView textNicknameValue;
    @BindView(R.id.text_sex_value)
    TextView textSexValue;
    @BindView(R.id.text_phone_value)
    TextView textPhoneValue;
    @BindView(R.id.text_birthday_value)
    TextView textBirthdayValue;
    @BindView(R.id.text_note_value)
    TextView textNoteValue;
    @BindView(R.id.root_layout)
    ViewGroup rootLayout;

    UserInfoController userInfoController;

    @Override
    public int getContentViewId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void refreshView() {
        setStatusBar();
        userInfoController = new UserInfoController(this);
        refresh();
    }

    private void refresh() {
        textNicknameValue.setText(Common.userObj.getNickname());
        textSexValue.setText(Common.userObj.getSex() == 0 ? "男" : "女");
        textPhoneValue.setText(Common.userObj.getPhone());
        textBirthdayValue.setText(Common.userObj.getBirthday());
        textNoteValue.setText(Common.userObj.getIntroduction());
        Glide.with(this).load(ApiConfig.baseUrl + "/wyk/head/" + Common.userObj.getImghead()).into(ivHead);
    }

    @Override
    public void addEvent() {

    }

    @OnClick({R.id.iv_back, R.id.layout_head, R.id.layout_nickname, R.id.layout_sex, R.id.layout_phone, R.id.layout_birthday, R.id.layout_note})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.layout_head:
                editHead();
                break;
            case R.id.layout_nickname:
                editInput("修改昵称", InputType.TYPE_CLASS_TEXT, 12, "nickname");
                break;
            case R.id.layout_sex:
                editSex();
                break;
            case R.id.layout_phone:
                editInput("修改手机号", InputType.TYPE_CLASS_PHONE, 12, "phone");
                break;
            case R.id.layout_birthday:
                editBirthday();
                break;
            case R.id.layout_note:
                editInput("修改个性签名", InputType.TYPE_TEXT_FLAG_MULTI_LINE, 100, "introduction");
                break;
        }
    }

    private void editInput(String title, int inputType, int inputNum, final String value) {
        DialogUtils.showInputDialog(this, title, inputType, inputNum, new DialogUtils.DialogCallBack<String>() {
            @Override
            public void onPositiveButton(String s) {
                super.onPositiveButton(s);
                Map<String, String> map = new HashMap<>();
                map.put(value, s);
                userInfoController.editUserInfo(map);
            }
        });
    }

    private void editSex() {
        DialogUtils.showSexDialog(this, Common.userObj.getSex(), new DialogUtils.DialogCallBack<Integer>() {
            @Override
            public void onPositiveButton(Integer integer) {
                super.onPositiveButton(integer);
                Map<String, String> map = new HashMap<>();
                map.put("sex", integer.toString());
                userInfoController.editUserInfo(map);
            }
        });
    }

    private void editBirthday() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                UserInfoActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    private void editHead() {
        DialogUtils.showPicDialog(this, new DialogUtils.DialogCallBack<String>() {
            @Override
            public void onPositiveButton(String s) {
                super.onPositiveButton(s);
                ImageSelectorActivity.start(UserInfoActivity.this, 1, ImageSelectorActivity.MODE_SINGLE, true, true, true);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE){
            ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
            userInfoController.uploadPic(images.get(0));
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Map<String, String> map = new HashMap<>();
        String month = monthOfYear < 10 ? "0" : "";
        month = month + (monthOfYear + 1);
        String day = dayOfMonth < 10 ? "0" : "";
        day = day + (dayOfMonth);
        map.put("birthday", year + "-" + month + "-" + day);
        userInfoController.editUserInfo(map);
    }

    @Override
    public void editSuccess() {
        userInfoController.queryUserInfo(Common.userObj.getId());
    }

    @Override
    public void querySuccess() {
        refresh();
    }

    @Override
    public void failure(String s) {
        Snackbar.make(rootLayout, s, Snackbar.LENGTH_LONG).show();
    }


}
