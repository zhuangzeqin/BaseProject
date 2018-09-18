package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login;

import android.support.annotation.NonNull;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.login.LoginModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.BasePresenter;

/**
 * 描述 P层处理界面想要的数据；返回给V层，解耦
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-15:57
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private final static String TAG = LoginPresenter.class.getSimpleName();

    /**
     * ------注释说明--登录------ 13424230742 or 123456q
     **/
    public void login(@NonNull String mobile_username, @NonNull String mobile_password) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isAttachView()) return;
        mView.showLoading();
//        AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mContext))
        LoginModel.with(mView).setTag(TAG).build().
                reqLonin(mobile_username, mobile_password, new ModelContract.IResultCallBack<LoginInfo.DataBean>() {
            @Override
            public void onSucess(String tag, LoginInfo.DataBean response) {
                mView.hideLoading();
                mView.loginSuccess(response.toString());
            }

            @Override
            public void onFailure(String tag, String message) {
                mView.hideLoading();
                mView.showError(message);
            }
        });
    }
}
