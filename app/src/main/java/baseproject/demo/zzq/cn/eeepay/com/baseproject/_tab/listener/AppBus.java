package baseproject.demo.zzq.cn.eeepay.com.baseproject._tab.listener;

import com.squareup.otto.Bus;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/5/14-16:38
 * 邮箱：zzq@eeepay.cn
 */
public class AppBus extends Bus {
    private AppBus() {
    }

    private static class SingletonHolder {
        private static final AppBus INSTANCE = new AppBus();
    }

    public static AppBus getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
