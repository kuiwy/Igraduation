package hello.wyk.graduation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyk.model.LeftMenuItemObj;
import com.wyk.model.QuestionObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hello.wyk.graduation.R;
import hello.wyk.graduation.util.ItemDataUtils;

/**
 * 侧边栏adapter
 * <p/>
 * Created by wyk on 2015/12/18.
 */
public class ErrorQuestionListAdapter extends MyBaseAdapter<QuestionObj> {
    public ErrorQuestionListAdapter(Context context, List<QuestionObj> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.item_error_question, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        QuestionObj itemObj = getItem(position);
        SpannableStringBuilder builder = new SpannableStringBuilder(itemObj.getStringType()+itemObj.getTitle());
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLUE);
        builder.setSpan(redSpan, 0, itemObj.getStringType().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.textQuestion.setText(builder);
        holder.textNum.setText("做错次数："+itemObj.getErrornum());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.text_question)
        TextView textQuestion;
        @BindView(R.id.text_num)
        TextView textNum;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
