package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.support.annotation.UiThread;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
 /**
   * 描述：一个Presenter和使用 getPresenter 方法获取实例
   * 作者：zhuangzeqin
   * 时间: 2018/7/31-17:53
   * 邮箱：zzq@eeepay.cn
   * 备注:
   */
@Route(path = "/mvp/TestMVPAct")
@CreatePresenter(presenter = LoginPresenter.class)
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
         getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 getPresenter().login();//调用登录请求
             }
         });
     }

     @Override
     protected void initData() {

     }


    @UiThread
    @Override
    public void loginSuccess() {
        ToastUtils.showLong("登录成功....");
    }
}
