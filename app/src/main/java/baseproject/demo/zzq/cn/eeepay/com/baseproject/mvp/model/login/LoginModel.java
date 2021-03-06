package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.login;

import android.support.annotation.NonNull;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.base.BaseModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.interfaces.IBaseView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.base.BaseObserver;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.bean.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxHttpErrorFunctionHelper;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.util.Utils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ApiUtil;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.Md5;

/**
 * 描述：登录的model
 * 数据的获取、存储、数据状态变化都将是Model层的任务
 * m层将数据 回到给P层
 * 作者：zhuangzeqin
 * 时间: 2018/8/20-14:50
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class LoginModel extends BaseModel implements ModelContract.ILoginModel2<LoginInfo.DataBean> {
    private String mTag;//设置请求的tag
    private IBaseView mView;//自动销毁的转换器;//自动销毁的转换器

    private LoginModel(Builder builder) {
        if (builder == null) return;
        this.mTag = builder.tag;
        this.mView = builder.view;
    }

    /**
     * 获取Builder 实例
     *
     * @return
     */
    public static Builder with(@NonNull IBaseView view) {
        return new Builder(view);
    }

    public static class Builder {
        private String tag;//设置请求的tag
        private IBaseView view;//自动销毁的转换器

        public Builder(@NonNull IBaseView view) {
            this.view = view;
        }

        //自动销毁的转换器
        public Builder setTag(@NonNull String tag) {
            this.tag = tag;
            return this;
        }

        /**
         * 静态内部类调用外部类的构造函数，来构造外部类
         * Builder类中的成员函数返回Builder对象自身的另一个作用就是让它支持链式调用，使代码可读性大大增强。
         *
         * @return
         */
        public LoginModel build() {
            return new LoginModel(this);
        }
    }

    @Override
    public void reqLonin(@NonNull String mobile_username, @NonNull String mobile_password, @NonNull final ModelContract.IResultCallBack<LoginInfo.DataBean> resultCallBack) {
        if (mView == null)
            throw new IllegalStateException("=== reqLonin mView is null===");
        if (resultCallBack == null)
            throw new IllegalStateException("=== resultCallBack is null===");
        mParams.put("apiTag", ApiUtil.MERLOGIN_NAME);
        mParams.put("mobile_username", mobile_username);
        mParams.put("mobile_password", Md5.encode(mobile_password));
        mParams.put("parentMer", "Y");//myInfo 接口新增请求参数 parentMer ,值为Y时,表示需要查询引路人信息,引路人的响应数据在 parMerInfo 参数中.
        mParams.put("getMerCapas", "Y");//add by zhuangzeqin 二〇一八年七月三日 10:48:00 myInfo 接口新增请求参数 新增getMerCapas参数,传Y,则会查询身份级别信息
        getApi().reqLonin(Utils.getUUID(),mParams).
                compose(RxSchedulersHelper.<Result<LoginInfo.DataBean>>io_main()).
                onErrorResumeNext(new RxHttpErrorFunctionHelper<Result<LoginInfo.DataBean>>()).
                as(mView.<Result<LoginInfo.DataBean>>bindAutoDispose()).subscribe(new BaseObserver<LoginInfo.DataBean>(this.mTag) {
            @Override
            public void onSucess(String tag, LoginInfo.DataBean response) {
                resultCallBack.onSucess(tag,response);
            }

            @Override
            public void onFailure(String tag, String message) {
                resultCallBack.onFailure(tag,message);
            }
        });
    }
}
