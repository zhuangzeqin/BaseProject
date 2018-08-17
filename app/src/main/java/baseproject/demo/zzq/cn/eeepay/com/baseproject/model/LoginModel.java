package baseproject.demo.zzq.cn.eeepay.com.baseproject.model;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.BaseObserver;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.ResultCallBack;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit.RetrofitManager;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/8/16-17:18
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class LoginModel{

    private void login()
    {
        String aa = "收货地址:广州市xxxxxxx";
        aa.substring(aa.indexOf(":")+1);



        RetrofitManager.getInstance().getApi().downLoadFile("").
                compose(RxSchedulersHelper.<Result<ResultCallBack>>io_main()).
                subscribeWith(new BaseObserver<ResultCallBack>() {


                    @Override
                    public void onSucess(ResultCallBack response) {

                    }

                    @Override
            public void onFailure(String message) {

            }
        });
    }


}
