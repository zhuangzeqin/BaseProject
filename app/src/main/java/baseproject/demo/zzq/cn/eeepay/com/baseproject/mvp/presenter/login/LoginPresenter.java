package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login;

import android.support.annotation.NonNull;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.login.LoginModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.BasePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.bean.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.util.Utils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ApiUtil;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.Md5;

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
        mParams.put("apiTag", ApiUtil.MERLOGIN_NAME);
        mParams.put("mobile_username", mobile_username);
        mParams.put("mobile_password", Md5.encode(mobile_password));
        mParams.put("parentMer", "Y");//myInfo 接口新增请求参数 parentMer ,值为Y时,表示需要查询引路人信息,引路人的响应数据在 parMerInfo 参数中.
        mParams.put("getMerCapas", "Y");//add by zhuangzeqin 二〇一八年七月三日 10:48:00 myInfo 接口新增请求参数 新增getMerCapas参数,传Y,则会查询身份级别信息
        LoginModel.with(TAG).//设置请求的tag
                setAutoDisposeConverter(mView.<Result<LoginInfo.DataBean>>bindAutoDispose())
                .build().reqLonin(Utils.getUUID(), mParams, new ModelContract.IResultCallBack<LoginInfo.DataBean>() {
            @Override
            public void onSucess(LoginInfo.DataBean response) {
                mView.hideLoading();
                mView.loginSuccess(response.toString());
            }

            @Override
            public void onFailure(String message) {
                mView.hideLoading();
                mView.showError("登录失败:" + message);
            }
        });
    }
}
