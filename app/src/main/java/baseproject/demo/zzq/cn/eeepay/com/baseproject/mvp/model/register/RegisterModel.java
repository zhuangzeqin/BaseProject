package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.register;

import android.support.annotation.NonNull;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.base.BaseModel;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.interfaces.ModelContract;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.bean.Result;
import io.reactivex.Observable;

/**
 * 描述：这里是注册的model,后续扩展；基本跟登录的model 是一样的；
 * 作者：zhuangzeqin
 * 时间: 2018/8/23-17:13
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class RegisterModel extends BaseModel implements ModelContract.IRegisterModel<String>{

    @Override
    public Observable<Result<LoginInfo.DataBean>> reqRegister(@NonNull String username, @NonNull String password, @NonNull ModelContract.IResultCallBack<String> resultCallBack) {
        return null;
    }
}
