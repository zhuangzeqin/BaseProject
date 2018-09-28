package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.support.annotation.UiThread;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.base.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginPresenter2;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import io.reactivex.functions.Consumer;

/**
   * 描述：一个Presenter和使用 getPresenter 方法获取实例
   * 作者：zhuangzeqin
   * 时间: 2018/7/31-17:53
   * 邮箱：zzq@eeepay.cn
   * 备注:
   */
@Route(path = "/mvp/TestMVPAct")
@CreatePresenter(presenter = LoginPresenter2.class)
public class TestMVPAct extends BaseMvpActivity<LoginPresenter> implements LoginView {

    @Override
    protected int getContentView() {
        return R.layout.activity_test_mvp;
    }

     @Override
     protected String setTitle() {
         return "一个Presenter的使用";
     }

     @Override
     protected void initView() {

     }

     @Override
     protected void eventOnClick() {
         RxView.clicks(getViewById(R.id.btn_login))
                 .throttleFirst(500, TimeUnit.SECONDS)   //防抖操作
                 .subscribe(new Consumer<Object>() {

                     @Override
                     public void accept(Object o) throws Exception {
                         getPresenter().login("13424230742", "123456q");//调用登录请求
                     }
                 });
         
//         getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
//             @Override
//             public void onClick(View view) {
//               
//             }
//         });
     }

     @Override
     protected void initData() {

     }


    @UiThread
    @Override
    public void loginSuccess(String msg) {
        ToastUtils.showLong(msg);
    }
}
