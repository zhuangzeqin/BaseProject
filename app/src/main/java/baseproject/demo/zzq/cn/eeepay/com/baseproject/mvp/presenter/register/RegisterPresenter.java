package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.register;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.BasePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.interfaces.PresenterContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 描述：注册
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-18:01
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class RegisterPresenter extends BasePresenter<RegisterView> implements PresenterContract.registerPresenter {

    @Override
    public void register() {
        Observable.interval(1, TimeUnit.SECONDS).
                doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        String format = String.format("doOnDispose run in thread %s ", Thread.currentThread().getName());
                        Log.i("register", "Unsubscribing subscription from onResume()"+format);
                    }
                }).
                compose(RxSchedulersHelper.<Long>io_main()).as(mView.<Long>bindAutoDispose())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        String format = String.format("accept run in thread %s ", Thread.currentThread().getName());
                        Log.d("register",aLong+":"+format);
                    }
                });
    }
}
