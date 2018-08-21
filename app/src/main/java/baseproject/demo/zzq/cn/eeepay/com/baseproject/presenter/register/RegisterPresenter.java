package baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.BasePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-18:01
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class RegisterPresenter extends BasePresenter<RegisterView> {

    public void register()
    {
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
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000*3);//模拟网络注册请求
//                    mView.hideLoading();
//                    mView.registerSuccess();//提示注册成功
//                } catch (InterruptedException e) {
//                    mView.showError("注册失败；请稍后重试...");                }
//            }
//        }).start();
    }
}
