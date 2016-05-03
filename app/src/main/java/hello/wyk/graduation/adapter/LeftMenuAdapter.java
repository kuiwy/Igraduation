package hello.wyk.graduation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyk.model.LeftMenuItemObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hello.wyk.graduation.R;

/**
 * 侧边栏adapter
 *
 * Created by wyk on 2015/12/18.
 */
public class LeftMenuAdapter extends MyBaseAdapter<LeftMenuItemObj> {
    public LeftMenuAdapter(Context context, List<LeftMenuItemObj> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.item_left_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        LeftMenuItemObj itemObj = getItem(position);
        holder.item_img.setImageResource(itemObj.getImg());
        holder.item_tv.setText(itemObj.getTitle());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.item_img)
        ImageView item_img;
        @BindView(R.id.item_tv)
        TextView item_tv;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
