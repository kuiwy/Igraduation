package hello.wyk.graduation.fragment;


import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import hello.wyk.graduation.R;

/**
 * 主页第一个Fragment
 * <p/>
 * Created by wyk on 2015/11/23.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.web_view)
    private WebView webView;

    @Override
    public int getViewId() {
        return R.layout.fragment_main;
    }

    @Override
    public void refreshView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://mp.weixin.qq.com/s?__biz=MzA4NTQwNDcyMA==&mid=2650661511&idx=1&sn=1b7390e2c971e50a0db4d07c7b9ebb6f&scene=0#wechat_redirect");
    }

    @Override
    public void addEvent() {

    }
}
