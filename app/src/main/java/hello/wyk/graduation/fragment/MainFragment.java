package hello.wyk.graduation.fragment;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.wyk.model.ArticleObj;

import org.wyk.core.ArticleController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.ArticleListAdapter;
import hello.wyk.graduation.widget.ProgressView;
import me.fangx.haorefresh.HaoRecyclerView;
import me.fangx.haorefresh.LoadMoreListener;

/**
 * 文章列表
 * Created by wyk on 2015/11/23.
 */
public class MainFragment extends BaseFragment implements ArticleController.ArticleCallBack {

    @BindView(R.id.recycle_view)
    HaoRecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    boolean isRefresh = false;
    boolean isLoadMore = false;

    List<ArticleObj> list;
    ArticleListAdapter adapter;
    ArticleController articleController;

    @Override
    public int getViewId() {
        return R.layout.fragment_main;
    }

    @Override
    public void refreshView() {
        refreshRecycleView();
        addProgressFoot();
        list = new ArrayList<>();
        adapter = new ArticleListAdapter(mActivity, list);
        recyclerView.setAdapter(adapter);

        articleController = new ArticleController(this);
        articleController.getArticleList(0);
    }

    private void refreshRecycleView() {
        swipeRefresh.setColorSchemeResources(R.color.textBlueDark, R.color.textBlueDark, R.color.textBlueDark,
                R.color.textBlueDark);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void addProgressFoot() {
        ProgressView progressView = new ProgressView(mActivity);
        progressView.setIndicatorId(ProgressView.BallPulse);
        progressView.setIndicatorColor(0xff69b3e0);
        recyclerView.setFootLoadingView(progressView);

        TextView textView = new TextView(mActivity);
        textView.setText("已经到底啦~");
        recyclerView.setFootEndView(textView);
    }

    @Override
    public void addEvent() {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        articleController.getArticleList(0);
                    }
                }, 1500);
            }
        });
        recyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        isLoadMore = true;
                        articleController.getArticleList(list.size());
                    }
                }, 1000);
            }
        });
    }


    @Override
    public void success(List<ArticleObj> list) {
        if (isRefresh) {
            isRefresh = false;
            recyclerView.refreshComplete();
            swipeRefresh.setRefreshing(false);
            this.list.clear();
        } else if (isLoadMore) {
            if (list.size() == 0)
                recyclerView.loadMoreEnd();
            else
                recyclerView.loadMoreComplete();
        }
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failure(String s) {
        Snackbar.make(recyclerView, s, Snackbar.LENGTH_LONG)
                .show();
    }
}
