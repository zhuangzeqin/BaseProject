package baseproject.demo.zzq.cn.eeepay.com.baseproject.model.login;

import android.support.annotation.NonNull;

import com.uber.autodispose.AutoDisposeConverter;

import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.model.base.BaseModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.BaseObserver;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.HttpErrorFunction;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;

/**
 * 描述：登录的model
 * 作者：zhuangzeqin
 * 时间: 2018/8/20-14:50
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class LoginModel2 extends BaseModel<LoginInfo.DataBean> implements ModelContract.ILoginModel2<LoginInfo.DataBean> {
    private static volatile LoginModel2 mInstance = null;

    private LoginModel2() {
    }
    /** ------注释说明---自动处理转换器----- **/
    @Override
    public void setDisposeConverter(AutoDisposeConverter<Result<LoginInfo.DataBean>> disposeConverter) {
        this.mDisposeConverter = disposeConverter;
    }

    public static LoginModel2 getInstance() {
        if (mInstance == null) {
            synchronized (LoginModel2.class) {
                if (mInstance == null) {
                    mInstance = new LoginModel2();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void reqLonin(@NonNull String uuid, @NonNull Map<String, Object> request, @NonNull final ModelContract.IResultCallBack<LoginInfo.DataBean> resultCallBack) {
        if (mDisposeConverter == null)
            throw new IllegalStateException("===DisposeConverter is null===");
        getApi().reqLonin(uuid, request).
                compose(RxSchedulersHelper.<Result<LoginInfo.DataBean>>io_main()).
                onErrorResumeNext(new HttpErrorFunction<Result<LoginInfo.DataBean>>()).
                as(this.mDisposeConverter).subscribe(new BaseObserver<LoginInfo.DataBean>() {
            @Override
            public void onSucess(LoginInfo.DataBean response) {
                resultCallBack.onSucess(response);
            }

            @Override
            public void onFailure(String message) {
                resultCallBack.onFailure(message);
            }
        });
    }
}
