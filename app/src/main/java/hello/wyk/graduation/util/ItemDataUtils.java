package hello.wyk.graduation.util;


import com.wyk.model.LeftMenuItemObj;

import org.wyk.core.util.Common;

import java.util.ArrayList;
import java.util.List;

import hello.wyk.graduation.R;

/**
 * 当前类注释:
 * ProjectName：DragHelper4QQ
 * Author:<a href="http://www.cniao5.com">菜鸟窝</a>
 * Description：
 * 菜鸟窝是一个只专注做Android开发技能的在线学习平台，课程以实战项目为主，对课程与服务”吹毛求疵”般的要求，
 * 打造极致课程，是菜鸟窝不变的承诺
 */
public class ItemDataUtils {
    public static List<LeftMenuItemObj> getItemBeans(){
        List<LeftMenuItemObj> itemBeans=new ArrayList<>();
        itemBeans.add(new LeftMenuItemObj(R.mipmap.ic_home_black_24dp,"主页",false));
        itemBeans.add(new LeftMenuItemObj(R.mipmap.ic_description_black_24dp,"随机练习",false));
        itemBeans.add(new LeftMenuItemObj(R.mipmap.ic_class_black_24dp,"分组练习",false));
        itemBeans.add(new LeftMenuItemObj(R.mipmap.ic_mode_edit_black_24dp,"错题",false));
        if(Common.userObj!=null)
            itemBeans.add(new LeftMenuItemObj(R.mipmap.ic_reply_black_24dp,"退出登录",false));
        return  itemBeans;
    }
    
}
