package baseproject.demo.zzq.cn.eeepay.com.baseproject.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：记录打开的act  当程序退出 finish掉所有的act
 * 作者：zhuangzeqin
 * 时间: 2018/7/10-16:32
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class ActivityManager {
    private List<Activity> mActivities = new ArrayList<>();

    private ActivityManager() {
    }

    private static class SingletonHolder {
        private static final ActivityManager INSTANCE = new ActivityManager();
    }

    public static ActivityManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public List<Activity> getActivities() {
        return mActivities;
    }

    public void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public void finish(Activity activity) {
        mActivities.remove(activity);
    }

    public void finishAll() {
        for (int i = 0; i < mActivities.size(); i++) {
            Activity activity = mActivities.get(i);
            if (!activity.isFinishing()) {
                activity.finish();
            }
            mActivities.remove(activity);
            i--;
        }
    }
}
