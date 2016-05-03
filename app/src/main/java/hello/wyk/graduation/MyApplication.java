package hello.wyk.graduation;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wyk on 2016/4/22.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }

}
