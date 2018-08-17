package baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit;

import android.support.v4.util.ArrayMap;

import io.reactivex.disposables.Disposable;

/**
 * 描述：RxJavaAction管理实现类
 * 作者：zhuangzeqin
 * 时间: 2018/8/16-22:19
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class RxActionManagerImpl implements IRxActionManager<Object> {
    private static volatile RxActionManagerImpl mInstance = null;
    private ArrayMap<Object, Disposable> mMaps;//处理,请求列表

    private RxActionManagerImpl() {
        mMaps = new ArrayMap<>();
    }

    public static RxActionManagerImpl getInstance() {
        if (mInstance == null) {
            synchronized (RxActionManagerImpl.class) {
                if (mInstance == null) {
                    mInstance = new RxActionManagerImpl();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void add(Object tag, Disposable disposable) {
        mMaps.put(tag, disposable);
    }

    @Override
    public void remove(Object tag) {
        if (!mMaps.isEmpty()) {
            mMaps.remove(tag);
        }
    }

    @Override
    public void cancel(Object tag) {
        if (mMaps.isEmpty()) {
            return;
        }
        if (mMaps.get(tag) == null) {
            return;
        }
        if (!mMaps.get(tag).isDisposed()) {
            mMaps.get(tag).dispose();
        }
        mMaps.remove(tag);
    }

    /**
     * 判断是否取消了请求
     *
     * @param tag
     * @return
     */
    public boolean isDisposed(Object tag) {
        if (mMaps.isEmpty() || mMaps.get(tag) == null) return true;
        return mMaps.get(tag).isDisposed();
    }

}
