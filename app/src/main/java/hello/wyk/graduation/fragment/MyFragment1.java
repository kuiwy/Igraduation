package hello.wyk.graduation.fragment;


import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hello.wyk.graduation.R;
import hello.wyk.graduation.adapter.ArticleAdapter;

/**
 * 主页第一个Fragment
 *
 * Created by wyk on 2015/11/23.
 */
public class MyFragment1 extends BaseFragment {

    private ListView mListViewTopic;
    private ArticleAdapter mArticleAdapter;
    private List<String> topicList;

    @Override
    public int getViewId() {
        return R.layout.fragment_1;
    }

    @Override
    protected void findView() {
        mListViewTopic = (ListView) mView.findViewById(R.id.list_topic);

    }

    @Override
    public void refreshView() {
//        topicList = new ArrayList<>();
//        topicList.add("");topicList.add("");topicList.add("");topicList.add("");topicList.add("");topicList.add("");
//        topicList.add("");topicList.add("");topicList.add("");topicList.add("");topicList.add("");topicList.add("");
//        mArticleAdapter = new ArticleAdapter(getActivity(),topicList);
//        mListViewTopic.setAdapter(mArticleAdapter);
    }

    @Override
    public void addEvent() {

    }
}
