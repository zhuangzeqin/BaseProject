package baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login;

import java.util.HashMap;
import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.LoginInfo;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.BasePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Api;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.ApiUtils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.BaseObserver;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Result;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit.RetrofitManager;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.rxhelper.RxSchedulersHelper;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.util.Utils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ApiUtil;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.Md5;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-15:57
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class LoginPresenter extends BasePresenter<LoginView>{
    Map<String, Object> params = new HashMap<>();
    public void login() {
        mView.showLoading();
        params = ApiUtils.getPubParams();//公共参数的请求
        params.put("apiTag", ApiUtil.MERLOGIN_NAME);
        params.put("mobile_username", "13424230742");
        params.put("mobile_password", Md5.encode("123456q"));
        params.put("parentMer", "Y");//myInfo 接口新增请求参数 parentMer ,值为Y时,表示需要查询引路人信息,引路人的响应数据在 parMerInfo 参数中.
        params.put("getMerCapas", "Y");//add by zhuangzeqin 二〇一八年七月三日 10:48:00 myInfo 接口新增请求参数 新增getMerCapas参数,传Y,则会查询身份级别信息
        Api api = RetrofitManager.getInstance().getApi();
        RetrofitManager.getInstance().getApi().reqLonin2(Utils.getUUID(),params).
                compose(RxSchedulersHelper.<Result<LoginInfo.DataBean>>io_main()).
                subscribe(new BaseObserver<LoginInfo.DataBean>() {
            @Override
            public void onSucess(LoginInfo.DataBean response) {
                mView.hideLoading();
                mView.loginSuccess(response.toString());
            }

            @Override
            public void onFailure(String message) {
                mView.showError("登录失败");
            }
        });

    /*    RetrofitManager.getInstance().getApi().reqLonin(Utils.getUUID(),params).
                compose(RxSchedulersHelper.<ResultCallBack>io_main()).
                subscribe(new Observer<ResultCallBack>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultCallBack resultCallBack) {
                        mView.hideLoading();
                        mView.loginSuccess(resultCallBack.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("登录失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

    }
}
