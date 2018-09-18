package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.base;

import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Api;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit.RetrofitManager;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.util.ApiUtils;

/**
 * 描述：抽象出一个BaseModel
 * 数据的获取、存储、数据状态变化都将是Model层的任务
 * 作者：zhuangzeqin
 * 时间: 2018/8/20-17:52
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class BaseModel{
    private Api api;//API 获取实例
    protected Map<String, Object> mParams;
    public BaseModel() {
        this.api = RetrofitManager.getInstance().getApi();
        this.mParams = ApiUtils.getPubParams();//公共参数的请求
    }
    public Api getApi() {
        return api;
    }
}
