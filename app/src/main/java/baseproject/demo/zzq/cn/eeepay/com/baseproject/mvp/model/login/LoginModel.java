package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.login;

import android.support.annotation.NonNull;

import com.uber.autodispose.AutoDisposeConverter;

import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.base.BaseModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.base.BaseObserver;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.bean.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxHttpErrorFunctionHelper;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;

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
    private AutoDisposeConverter<Result<LoginInfo.DataBean>> mDisposeConverter;//自动销毁的转换器

    private LoginModel(Builder builder) {
        this.mTag = builder.tag;
        this.mDisposeConverter = builder.disposeConverter;
    }

    /**
     * 获取Builder 实例
     *
     * @return
     */
    public static Builder with(@NonNull String tag) {
        return new Builder(tag);
    }

    public static class Builder {
        private String tag;//设置请求的tag
        private AutoDisposeConverter<Result<LoginInfo.DataBean>> disposeConverter;//自动销毁的转换器

        public Builder(String tag) {
            this.tag = tag;
        }

        //自动销毁的转换器
        public Builder setAutoDisposeConverter(@NonNull AutoDisposeConverter<Result<LoginInfo.DataBean>> disposeConverter) {
            this.disposeConverter = disposeConverter;
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
    public void reqLonin(@NonNull String uuid, @NonNull Map<String, Object> request, @NonNull final ModelContract.IResultCallBack<LoginInfo.DataBean> resultCallBack) {
        if (mDisposeConverter == null)
            throw new IllegalStateException("=== DisposeConverter is null===");
        if (resultCallBack == null)
            throw new IllegalStateException("=== resultCallBack is null===");
        getApi().reqLonin(uuid, request).
                compose(RxSchedulersHelper.<Result<LoginInfo.DataBean>>io_main()).
                onErrorResumeNext(new RxHttpErrorFunctionHelper<Result<LoginInfo.DataBean>>())
                .as(mDisposeConverter).
                subscribe(new BaseObserver<LoginInfo.DataBean>(this.mTag) {
                    @Override
                    public void onSucess(LoginInfo.DataBean response) {
                        resultCallBack.onSucess(response);//m层将数据 回到给P层
                    }

                    @Override
                    public void onFailure(String message) {
                        resultCallBack.onFailure(message);
                    }
                });
    }

}
