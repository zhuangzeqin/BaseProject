package baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.interfaces.IBaseView;

/**
 * 描述：登录需要相关的View的操作
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-15:55
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public interface LoginView extends IBaseView{
    void loginSuccess(String msg);//登录成功
}
