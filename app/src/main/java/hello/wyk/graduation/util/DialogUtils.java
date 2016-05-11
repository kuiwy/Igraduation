package hello.wyk.graduation.util;


import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.wyk.core.util.CheckUtil;

import java.util.HashMap;

import hello.wyk.graduation.R;
import hello.wyk.graduation.activity.BaseActivity;


/**
 * 常用dialog的静态调用工具（含回调）
 *
 * @author yxw
 */
public class DialogUtils {


    public static void loginDialog(final BaseActivity context, final DialogCallBack<HashMap<String,String>> callBack) {
        final EditText editUsername,editPassword;
        final TextView errorUsername,errorPassword;
        View positiveAction;
        try {
            final MaterialDialog dialog = new MaterialDialog.Builder(context)
                    .title(R.string.login)
                    .customView(R.layout.dialog_login, true)
                    .positiveText(R.string.submit)
                    .negativeText(R.string.register)
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.dismiss();
                            callBack.onNegativeButton(null);
                        }
                    }).build();
            positiveAction = dialog.getActionButton(DialogAction.POSITIVE);
            editUsername = (EditText) dialog.getCustomView().findViewById(R.id.edit_username);
            editPassword = (EditText) dialog.getCustomView().findViewById(R.id.edit_password);
            errorUsername = (TextView) dialog.getCustomView().findViewById(R.id.text_username_error);
            errorPassword = (TextView) dialog.getCustomView().findViewById(R.id.text_password_error);
            errorUsername.setVisibility(View.INVISIBLE);
            errorPassword.setVisibility(View.INVISIBLE);
            editUsername.addTextChangedListener(new SimpleTextWatcher(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(CheckUtil.isUsername(s.toString())){
                        errorUsername.setVisibility(View.INVISIBLE);
                    }
                }
            });
            editPassword.addTextChangedListener(new SimpleTextWatcher(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(CheckUtil.isPassword(s.toString())){
                        errorPassword.setVisibility(View.INVISIBLE);
                    }
                }
            });
            positiveAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!CheckUtil.isUsername(editUsername.getText().toString())){
                        errorUsername.setVisibility(View.VISIBLE);
                    } else if(!CheckUtil.isPassword(editPassword.getText().toString())){
                        errorPassword.setVisibility(View.VISIBLE);
                    } else {
                        HashMap<String,String> map = new HashMap<>();
                        map.put("username",editUsername.getText().toString());
                        map.put("password",editPassword.getText().toString());
                        callBack.onPositiveButton(map);
                        dialog.dismiss();
                    }

                }
            });
            dialog.show();
        } catch (Exception e) {
            Log.e("wyk", "activity is not running!");
        }
    }

    public static void registerDialog(final BaseActivity context, final DialogCallBack<HashMap<String,String>> callBack) {
        final EditText editUsername,editPassword,editNickname;
        final TextView errorUsername,errorPassword,errorNickname;
        View positiveAction;
        try {
            final MaterialDialog dialog = new MaterialDialog.Builder(context)
                    .title(R.string.register)
                    .customView(R.layout.dialog_register, true)
                    .positiveText(R.string.submit)
                    .negativeText(R.string.cancel)
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.dismiss();
                        }
                    }).build();
            positiveAction = dialog.getActionButton(DialogAction.POSITIVE);
            editUsername = (EditText) dialog.getCustomView().findViewById(R.id.edit_username);
            editPassword = (EditText) dialog.getCustomView().findViewById(R.id.edit_password);
            editNickname = (EditText) dialog.getCustomView().findViewById(R.id.edit_nickname);
            errorUsername = (TextView) dialog.getCustomView().findViewById(R.id.text_username_error);
            errorPassword = (TextView) dialog.getCustomView().findViewById(R.id.text_password_error);
            errorNickname = (TextView) dialog.getCustomView().findViewById(R.id.text_nickname_error);
            errorUsername.setVisibility(View.INVISIBLE);
            errorPassword.setVisibility(View.INVISIBLE);
            errorNickname.setVisibility(View.INVISIBLE);
            editUsername.addTextChangedListener(new SimpleTextWatcher(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(CheckUtil.isUsername(s.toString())){
                        errorUsername.setVisibility(View.INVISIBLE);
                    }
                }
            });
            editPassword.addTextChangedListener(new SimpleTextWatcher(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(CheckUtil.isPassword(s.toString())){
                        errorPassword.setVisibility(View.INVISIBLE);
                    }
                }
            });
            editNickname.addTextChangedListener(new SimpleTextWatcher(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(CheckUtil.isPassword(s.toString())){
                        errorNickname.setVisibility(View.INVISIBLE);
                    }
                }
            });
            positiveAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!CheckUtil.isUsername(editUsername.getText().toString())){
                        errorUsername.setVisibility(View.VISIBLE);
                    } else if(!CheckUtil.isPassword(editPassword.getText().toString())){
                        errorPassword.setVisibility(View.VISIBLE);
                    } else if(TextUtils.isEmpty(editNickname.getText().toString())){
                        errorNickname.setVisibility(View.VISIBLE);
                    } else {
                        HashMap<String,String> map = new HashMap<>();
                        map.put("username",editUsername.getText().toString());
                        map.put("password",editPassword.getText().toString());
                        map.put("nickname",editNickname.getText().toString());
                        callBack.onPositiveButton(map);
                        dialog.dismiss();
                    }

                }
            });
            dialog.show();
        } catch (Exception e) {
            Log.e("wyk", "activity is not running!");
        }
    }

    public static void showInputDialog(final BaseActivity activity, String title, int inputType, int num, final DialogCallBack<String> callBack){
        new MaterialDialog.Builder(activity)
                .title(title)
                .inputRangeRes(1, num, R.color.material_red_500)
                .inputType(inputType)
                .input(null, null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        callBack.onPositiveButton(input.toString());
                    }
                }).show();
    }

    public static void showSexDialog(final BaseActivity activity,int sex, final DialogCallBack<Integer> callBack){
        new MaterialDialog.Builder(activity)
                .title("修改性别")
                .items(R.array.sex)
                .itemsCallbackSingleChoice(sex, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        callBack.onPositiveButton(which);
                        return true;
                    }
                })
                .positiveText("确认")
                .show();
    }

    public static void showPicDialog(final BaseActivity activity,final DialogCallBack<String> callBack){
        new MaterialDialog.Builder(activity)
                .content("是否修改头像")
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        callBack.onPositiveButton(null);
                    }
                })
                .show();
    }

    static class SimpleTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    public abstract static class DialogCallBack<T> {
        public DialogCallBack() {
        }

        public void onPositiveButton(T t) {

        }

        public void onNegativeButton(Object o) {

        }

        public void onButton(Object o, int flag) {

        }
    }

}





