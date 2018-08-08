package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.Manifest;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.CreatePresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.annotated.PresenterVariable;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.login.LoginView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterPresenter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.presenter.register.RegisterView;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.viewbyid.OnClickEvent;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.viewbyid.OnLongClickEvent;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.viewbyid.ViewById;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 描述：多个Presenter和使用采用注解方法获取实例
 * 作者：zhuangzeqin
 * 时间: 2018/7/31-17:53
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/mvp/TestMVPAct2")
@CreatePresenter(presenter = {LoginPresenter.class, RegisterPresenter.class})
public class TestMVPAct2 extends BaseMvpActivity implements LoginView, RegisterView, EasyPermissions.PermissionCallbacks {
    @PresenterVariable//采用注解无需new
    private LoginPresenter mLoginPresenter;
    @PresenterVariable
    private RegisterPresenter mRegisterPresenter;

    @ViewById(R.id.btn_login)
    private Button btn_login;

    @ViewById(R.id.btn_register)
    private Button btn_register;

    @ViewById(R.id.btn_tes)
    private Button btn_test;

    @Override
    protected int getContentView() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected String setTitle() {
        return "采用注解方法获取实例";
    }

    @Override
    protected void initView() {

        initBgBar(R.color.eposp_red_2);
    }

    @Override
    protected void initBgBar(int id) {
        super.initBgBar(id);
    }

    @Override
    protected void eventOnClick() {
//        getViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mLoginPresenter.login();//调用登录请求
//            }
//        });
//
//        getViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mRegisterPresenter.register();//调用注册请求
//            }
//        });
    }

   /* @OnClickEvent(R.id.btn_login)
    public void onClickEvent(View view) {
        mLoginPresenter.login();//调用登录请求
    }*/
    @OnClickEvent({R.id.btn_login, R.id.btn_register})
    public void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ListView mListView = null;
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });

                mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        return false;
                    }
                });
                mLoginPresenter.login();//调用登录请求
                break;
            case R.id.btn_register:
                mRegisterPresenter.register();//调用注册请求
                break;
        }
    }

    @OnLongClickEvent(R.id.btn_tes)
    public void onLongClickEvent(View view)
    {
        ToastUtils.showShort("测试一一下长按事件");
    }

    @Override
    protected void initData() {
        initpermission();
    }

    private void initpermission() {
        //存储SD卡权限
        String perms[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        //查看权限是否已申请
        if (!EasyPermissions.hasPermissions(mContext, perms)) {
            EasyPermissions.requestPermissions(this,
                    "接下来需要获取WRITE_EXTERNAL_STORAGE和READ_EXTERNAL_STORAGE权限",
                    1,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
        } else {
            ToastUtils.setBgColor(Color.parseColor("#ff7e00"));
            ToastUtils.setMsgColor(Color.parseColor("#ffffff"));
            ToastUtils.setGravity(Gravity.CENTER, 0, 0);
            ToastUtils.showShort("用户授权成功aaaa");
        }
    }

    @UiThread
    @Override
    public void loginSuccess() {
        ToastUtils.showLong("登录成功....");
    }

    @UiThread
    @Override
    public void registerSuccess() {
        ToastUtils.showLong("注册成功....");
    }

    /**
     * 当权限被成功申请的时候执行回调，requestCode是代表你权限请求的识别码，list里面装着申请的权限的名字：
     */
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        ToastUtils.showShort("权限获取成功");
    }

    /**
     * 当权限申请失败的时候执行的回调，参数意义同上。在这个方法里面，
     * 官方还建议用EasyPermissions.somePermissionPermanentlyDenied(this, perms)方法来判断是否有权限被勾选了不再询问并拒绝，还提供了一个AppSettingsDialog来给我们使用，在这个对话框里面解释了APP需要这个权限的原因，用户按下是的话会跳到APP的设置界面，可以去设置权限（是不是很不要脸_）,这个Dialog可以使用默认的样式new AppSettingsDialog.Builder(this).build().show()，
     * 也可以定制，像下面的一样：
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        ToastUtils.showShort("权限获取失败");
        /**
         * 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
         * 这时候，需要跳转到设置界面去，让用户手动开启。
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog
                    .Builder(this)
                    .setRationale("此功能需要存储权限，否则无法正常使用，是否打开设置")
                    .setPositiveButton("确定")
                    .setNegativeButton("取消")
                    .build()
                    .show();
        }
    }
}
