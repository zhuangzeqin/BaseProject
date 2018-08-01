package baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.BasePresenter;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-15:57
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class LoginPresenter extends BasePresenter<LoginView>{
    public void login() {
        mView.showLoading();
        //模拟网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000*3);
                    mView.hideLoading();
                    mView.loginSuccess();
                } catch (InterruptedException e) {
                    mView.showError("登录失败");
                }

            }
        }).start();

    }
}
