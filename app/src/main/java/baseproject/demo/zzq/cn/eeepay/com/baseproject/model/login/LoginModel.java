package baseproject.demo.zzq.cn.eeepay.com.baseproject.model.login;

import android.support.annotation.NonNull;

import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.model.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit.RetrofitManager;
import io.reactivex.Observable;

/**
 * 描述：登录的model
 * 作者：zhuangzeqin
 * 时间: 2018/8/20-14:50
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class LoginModel implements ModelContract.ILoginModel {
    private static volatile LoginModel mInstance = null;

    private LoginModel() {

    }

    public static LoginModel getInstance() {
        if (mInstance == null) {
            synchronized (LoginModel.class) {
                if (mInstance == null) {
                    mInstance = new LoginModel();
                }
            }
        }
        return mInstance;
    }

    @Override
    public Observable<Result<LoginInfo.DataBean>> reqLonin(@NonNull String uuid, @NonNull Map<String, Object> request) {
        return RetrofitManager.getInstance().getApi().reqLonin(uuid, request);
    }

}
