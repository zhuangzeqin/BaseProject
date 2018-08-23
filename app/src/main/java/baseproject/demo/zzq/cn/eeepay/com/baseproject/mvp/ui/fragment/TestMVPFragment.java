package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.fragment;

import android.support.annotation.UiThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.PresenterVariable;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.register.RegisterPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.register.RegisterView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base.BaseMvpFragment;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.btn_login)
     Button btn_Login;
    @BindView(R.id.btn_register)
     Button btn_Register;
    int i = 0;

    @UiThread
    @Override
    public void loginSuccess(String msg) {
        i++;
        Log.i("zhuangzeqin", String.valueOf(i));
        ToastUtils.showLong(msg);
    }

    @UiThread
    @Override
    public void registerSuccess() {
        ToastUtils.showLong("注册成功....");
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onclickView(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mLoginPresenter.login("13424230742", "123456q");//调用登录请求
                break;
            case R.id.btn_register:
                mRegisterPresenter.register();//调用注册请求
                break;
        }
    }

    /**
     * 懒加载
     */
    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        mLoginPresenter.login("13424230742", "123456q");//调用登录请求
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected void init() {
//        getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mLoginPresenter.login("13424230742", "123456q");//调用登录请求
//            }
//        });
//
//        getViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mRegisterPresenter.register();//调用注册请求
//            }
//        });
    }
}
