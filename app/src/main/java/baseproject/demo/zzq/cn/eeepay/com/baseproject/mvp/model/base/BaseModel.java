package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.model.base;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.api.Api;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.rxhttp.api.retrofit.RetrofitManager;

/**
 * 描述：抽象出一个BaseModel
 * 数据的获取、存储、数据状态变化都将是Model层的任务
 * 作者：zhuangzeqin
 * 时间: 2018/8/20-17:52
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class BaseModel{
    private Api api;
    public BaseModel() {
        this.api = RetrofitManager.getInstance().getApi();
    }
    public Api getApi() {
        return api;
    }
}
