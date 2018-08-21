package baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper;


import com.orhanobut.logger.Logger;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.exception.ExceptionEngine;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * http结果处理函数
 *
 * @author ZhongDaFeng
 */
public class HttpErrorFunction<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        //打印具体错误
        Logger.e("HttpErrorFunction:" + throwable);
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
