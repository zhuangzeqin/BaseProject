package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseFitsSystemWindowsActivity;

/**
 * 描述：ARouter 路由、通信、解耦
 * 作者：zhuangzeqin
 * 时间: 2018/7/24-14:46
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/ARouterGroup/ARouterAct")
public class ARouterAct extends BaseFitsSystemWindowsActivity {
    @Override
    protected String setTitle() {
        return "ARouter路由框架基本使用";
    }

    @Override
    protected int getBarColorId() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {




    }

    @Override
    public void eventOnClick() {

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}
