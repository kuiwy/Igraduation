package hello.wyk.graduation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hello.wyk.graduation.R;

/**
 * Created by wyk on 2015/12/4.
 */
public class TopicAdapter extends MyBaseAdapter<String> {

    public TopicAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.list_topic_item, parent, false);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder {
    }
}
