package baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.BasePresenter;

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
        mView.showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000*3);//模拟网络注册请求
                    mView.hideLoading();
                    mView.registerSuccess();//提示注册成功
                } catch (InterruptedException e) {
                    mView.showError("注册失败；请稍后重试...");                }
            }
        }).start();
    }
}
