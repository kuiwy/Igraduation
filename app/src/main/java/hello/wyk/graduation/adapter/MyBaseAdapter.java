package hello.wyk.graduation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 抽象适配器（免去一些有共性的代码）
 *
 * @param <T>
 * Created by wyk on 2015/12/3.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

        protected Context mContext;

        protected List<T> mListData;

        protected LayoutInflater mLayoutInflater;

        public MyBaseAdapter(Context context,List<T> listData){
            mContext = context;
            mListData = listData;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if(mListData!=null){
                return mListData.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if(mListData!=null){
                return mListData.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public List<T> getListData() {
            return mListData;
        }

        public void setListData(List<T> listData) {
            mListData = listData;
        }
}
