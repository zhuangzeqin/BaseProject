package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.fragment;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.PresenterVariable;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginPresenter2;
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
@CreatePresenter(presenter = {
        LoginPresenter.class,
        RegisterPresenter.class,
        LoginPresenter2.class})
public class TestMVPFragment extends BaseMvpFragment implements LoginView, RegisterView {
    @PresenterVariable//采用注解无需new
    private LoginPresenter mLoginPresenter;
    @PresenterVariable//采用注解无需new
    private LoginPresenter2 mLoginPresenter2;
    @PresenterVariable
    private RegisterPresenter mRegisterPresenter;
    @BindView(R.id.btn_login)
    Button btn_Login;
    @BindView(R.id.btn_register)
    Button btn_Register;
    @BindView(R.id.btn_tes)
    Button btnTes;
    @BindView(R.id.clroot)
    ConstraintLayout clRoot;
    @BindView(R.id.ll_mRootView)
    LinearLayout llRootView;
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

    @OnClick({R.id.btn_login, R.id.btn_register,R.id.btn_tes})
    public void onclickView(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //所有子View
                mLoginPresenter2.login("13424230742", "123456q");//调用登录请求
//                mLoginPresenter.login("13424230742", "123456q");//调用登录请求
                break;
            case R.id.btn_register:
                mRegisterPresenter.register();//调用注册请求
                break;
            case R.id.btn_tes:
                break;
        }
    }

    /**
     * 懒加载
     */
    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
//        mLoginPresenter.login("13424230742", "123456q");//调用登录请求
        mLoginPresenter2.login("13424230742", "123456q");//调用登录请求
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected void init() {

//        View custom = LayoutInflater.from(mContext)
//                .inflate(R.layout.layout_custom, null);
//        ((ImageView) (custom.findViewById(R.id.iv_custom))).setImageResource(R.mipmap.agency_nor);
//        ((TextView) custom.findViewById(R.id.tv_custom_content)).setText("This is PageLayout");
//        mPageLayout = new PageLayout.Builder(mContext)
//                .initPage(clRoot)
//                .setLoading(R.layout.layout_loading_demo, R.id.tv_page_loading_demo)
//                .setEmpty(R.layout.layout_empty, R.id.tv_page_empty)
//                .setCustomView(custom)
//                .setError(R.layout.layout_error, R.id.tv_page_error_retry, new PageLayout.OnRetryClickListener() {
//                    @Override
//                    public void onRetry() {
//                        ToastUtils.showShort("重试加载");
//                        mPageLayout.showEmpty();
//                    }
//                })
//                .setEmptyDrawable(R.drawable.pic_empty)
//                .setErrorDrawable(R.drawable.pic_error)
//                .setLoadingText("玩命加载中....")
//                .create();
    }
}
