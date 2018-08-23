package baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper;


import com.orhanobut.logger.Logger;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.exception.ExceptionEngine;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
 /**
   * 描述：http error 结果统一处理函数
   * 作者：zhuangzeqin
   * 时间: 2018/8/23-16:31
   * 邮箱：zzq@eeepay.cn
   * 备注:
   */
public  class RxHttpErrorFunctionHelper<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        //打印具体错误
        Logger.e("RxHttpErrorFunctionHelper:" + throwable);
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
