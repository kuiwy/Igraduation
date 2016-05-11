package hello.wyk.graduation.adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wyk.model.ArticleObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hello.wyk.graduation.R;
import hello.wyk.graduation.activity.BaseActivity;
import hello.wyk.graduation.fragment.ArticleFragment;

/**
 * Created by wyk on 2015/12/4.
 */
public class ArticleAdapter extends MyBaseAdapter<ArticleObj> {

    public ArticleAdapter(Context context, List<ArticleObj> listData) {
        super(context, listData);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.item_article_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ArticleObj item = mListData.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.textTime.setText(item.getCreatetime());
        holder.textSummary.setText(item.getSummary());
        Glide.with(mContext).load(item.getImgurl()).into(holder.imgArticle);
        holder.rippleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = ((BaseActivity)mContext).getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_content, ArticleFragment.newInstance(item.getUrl())).addToBackStack("list").commit();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.img_Article)
        ImageView imgArticle;
        @BindView(R.id.text_summary)
        TextView textSummary;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.ripple_layout)
        ViewGroup rippleLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
