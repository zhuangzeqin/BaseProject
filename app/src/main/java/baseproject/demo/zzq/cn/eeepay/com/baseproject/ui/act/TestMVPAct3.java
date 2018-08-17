package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.support.annotation.UiThread;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;

/**
 * 描述：多个Presenter和使用 getPresenter 方法获取实例
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-17:53
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/mvp/TestMVPAct3")
@CreatePresenter(presenter = {LoginPresenter.class, RegisterPresenter.class})
public class TestMVPAct3 extends BaseMvpActivity implements LoginView, RegisterView {
    @Override
    protected int getContentView() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected String setTitle() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void eventOnClick() {
        getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginPresenter mLoginPresenter = getPresenterProviders().getPresenter(0);
                mLoginPresenter.login();//调用登录请求
            }
        });

        getViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterPresenter mRegisterPresenter = getPresenterProviders().getPresenter(1);
                mRegisterPresenter.register();//调用注册请求
            }
        });
    }

    @Override
    protected void initData() {

    }

    @UiThread
    @Override
    public void loginSuccess(String msg) {
        ToastUtils.showLong(msg);
    }

    @UiThread
    @Override
    public void registerSuccess() {
        ToastUtils.showLong("注册成功....");
    }
}
