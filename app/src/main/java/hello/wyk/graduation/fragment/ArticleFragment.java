package hello.wyk.graduation.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import hello.wyk.graduation.R;

/**
 *
 * Created by wyk on 2016/5/10.
 */
public class ArticleFragment extends BaseFragment {
    @BindView(R.id.web_view)
    WebView webView;


    public static Fragment newInstance(String articleUrl){
        ArticleFragment fragment = new ArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", articleUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_article;
    }

    @Override
    public void refreshView() {
        loadWebView(getArguments().getString("url"));
    }

    @Override
    public void addEvent() {

    }

    @SuppressLint("SetJavaScriptEnabled")
    public void loadWebView(String url){
        //设置WebView属性，能够执行Javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webView.loadUrl(url);
        //设置Web视图
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
