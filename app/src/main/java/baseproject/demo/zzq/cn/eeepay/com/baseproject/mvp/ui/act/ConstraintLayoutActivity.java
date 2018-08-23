package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base.BaseFitsSystemWindowsActivity;

/**
 * 描述：ConstraintLayout 布局的的使用
 * 有效的减少的布局的嵌套的层级
 * 作者：zhuangzeqin
 * 时间: 2018/7/25-12:03
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/test/ConstraintLayoutActivity")
public class ConstraintLayoutActivity extends BaseFitsSystemWindowsActivity {
    @Override
    protected String setTitle() {
        return "ConstraintLayout布局的的使用";
    }

    @Override
    protected int getBarColorId() {
        return R.color.style_btn_color_nor;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_constraint_layout;
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
