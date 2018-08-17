package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.fragment;

import android.support.annotation.UiThread;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.PresenterVariable;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseMvpFragment;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/8/1-9:39
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/mvp/TestMVPFragment")
@CreatePresenter(presenter = {LoginPresenter.class, RegisterPresenter.class})
public class TestMVPFragment extends BaseMvpFragment implements LoginView, RegisterView {
    @PresenterVariable//采用注解无需new
    private LoginPresenter mLoginPresenter;
    @PresenterVariable
    private RegisterPresenter mRegisterPresenter;

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

    /**
     * 懒加载
     */
    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        mLoginPresenter.login();//调用登录请求
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected void init() {
        getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login();//调用登录请求
            }
        });

        getViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRegisterPresenter.register();//调用注册请求
            }
        });
    }
}
