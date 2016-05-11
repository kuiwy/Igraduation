package hello.wyk.graduation.adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wyk.model.ArticleObj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hello.wyk.graduation.R;
import hello.wyk.graduation.activity.BaseActivity;
import hello.wyk.graduation.fragment.ArticleFragment;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {
    public List<ArticleObj> datas = null;
    public Context mContext;

    public ArticleListAdapter(Context context, List<ArticleObj> datas) {
        this.datas = datas;
        mContext = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_article_list, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final ArticleObj item = datas.get(position);
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textTime.setText(item.getCreatetime());
        viewHolder.textSummary.setText(item.getSummary());
        Glide.with(mContext).load(item.getImgurl()).into(viewHolder.imgArticle);
        viewHolder.rippleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = ((BaseActivity)mContext).getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_content, ArticleFragment.newInstance(item.getUrl())).addToBackStack("list").commit();
            }
        });
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        public TextView textTitle;
        @BindView(R.id.text_time)
        public TextView textTime;
        @BindView(R.id.img_Article)
        public ImageView imgArticle;
        @BindView(R.id.text_summary)
        public TextView textSummary;
        @BindView(R.id.card_view)
        public CardView cardView;
        @BindView(R.id.ripple_layout)
        public ViewGroup rippleLayout;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
