package hello.wyk.graduation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyk.model.LeftMenuItemObj;

import java.util.List;

import hello.wyk.graduation.R;

/**
 * Created by wyk on 2015/12/18.
 */
public class LeftMenuAdapter extends MyBaseAdapter<LeftMenuItemObj> {
    public LeftMenuAdapter(Context context, List<LeftMenuItemObj> listData) {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.item_left_layout, parent, false);
            holder = new ViewHolder();
            holder.item_img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);
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
        ImageView item_img;
        TextView item_tv;
    }
}
