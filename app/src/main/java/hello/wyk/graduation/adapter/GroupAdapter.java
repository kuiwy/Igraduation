package hello.wyk.graduation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyk.model.GroupObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hello.wyk.graduation.R;

/**
 * 侧边栏adapter
 *
 * Created by wyk on 2015/12/18.
 */
public class GroupAdapter extends MyBaseAdapter<GroupObj> {
    public GroupAdapter(Context context, List<GroupObj> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.item_group_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        GroupObj itemObj = getItem(position);
        holder.textGroupName.setText(itemObj.getGroupname());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.text_group_name)
        TextView textGroupName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
