package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.interfaces.BaseViewInfterface;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ActivityManager;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.VirturlUtil;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 描述：抽象Act基类
 * 作者：zhuangzeqin
 * 时间: 2018/7/10-16:12
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseViewInfterface {
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    /***获取Toolbar**/
    protected Toolbar mToolbar;
    /***获取title**/
    private TextView mTv_title;
    /***获取右边的标题**/
    protected TextView tv_rightTitle;
    /***获取返回的图标**/
    protected TextView iv_back;
    /**
     * 上下文对象
     **/
    protected Context mContext;

    /**
     * 获取右边的标题
     **/
    public TextView getTv_rightTitle() {
        return tv_rightTitle;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /** 设置布局 **/
        setContentView(getLayoutId());
        //解决华为虚拟键冲突遮挡底部按钮
        VirturlUtil.assistActivity(findViewById(android.R.id.content));
        /** 设置状态栏问题颜色（黑/白） **/
        setStatusBarTextLight(true);
        /** 设置初始化 ToolBar **/
        initToolBar(setTitle());
        /** 沉浸式状态栏背景设置**/
        initBgBar(getBarColorId());
        /** 设置初始化 View **/
        initView();
        /** 设置点击事件操作**/
        eventOnClick();
        /** 初始化数据**/
        initData();
        /** 设置添加到ActivityManager 管理类**/
        ActivityManager.getInstance().addActivity(this);
    }

    /**
     * 重写onRequestPermissionsResult，用于接受请求结果
     *
     * @param requestCode  请求的唯一code
     * @param permissions  一些列的请求权限
     * @param grantResults 用户授权的结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将请求结果传递EasyPermission库处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 沉浸式状态栏背景设置
     **/
    private void initBgBar(@ColorRes int id) {
        if (mToolbar!=null)
            mToolbar.setBackgroundColor(getResources().getColor(id));//颜色设置
//        mToolbar.setBackgroundResource(R.mipmap.icon_shopping_goods_bg);//图片
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api >= 21
//            getWindow().setNavigationBarColor(Color.parseColor("#1bb5d7"));
            getWindow().setNavigationBarColor(getResources().getColor(id));
            //getWindow().setNavigationBarColor(Color.BLUE);
        }
    }


    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mTv_title.setText(title);
        }
    }

    /**
     * 初始化 ToolBar
     *
     * @param title
     */
    protected void initToolBar(String title) {
        mToolbar = findViewById(R.id.toolbar);
        if (mToolbar != null) {
            ToastUtils.showLong("mToolbar 不为空");
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("");
            mTv_title = findViewById(R.id.tv_title);
            if (!TextUtils.isEmpty(title) && mTv_title != null) {
                mTv_title.setText(title);
            }
            iv_back = findViewById(R.id.iv_back);
            tv_rightTitle = findViewById(R.id.tv_rightTitle);
            if (iv_back != null) {
                iv_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        }
        else
        {
            ToastUtils.showLong("mToolbar 控件为空");
        }
    }

    /**
     * 设置状态栏问题颜色（黑/白）
     *
     * @param isLight true:白色 false:黑色
     */
    protected void setStatusBarTextLight(boolean isLight) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | (isLight ? View.SYSTEM_UI_FLAG_LAYOUT_STABLE : View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR));
        }
    }

    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
         */
        if ((getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    /**
     * 在支持路由的页面上添加注解(必选)
     * 这里的路径需要注意的是至少需要有两级，/xx/xx
     *
     * @param path
     * @Route(path = "/test/activity")
     */
    protected void goActivity(@NonNull final String path) {
        //应用内简单的跳转带转场动画(常规方式)
        ARouter.getInstance().build(path).withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).navigation();
    }

    /**
     * 路由跳转Activity 并携带Bundle
     *
     * @param path
     * @param bundle
     */
    protected void goActivity(@NonNull final String path, Bundle bundle) {
        if (bundle == null)
            goActivity(path);
        else
            ARouter.getInstance().build(path).withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).with(bundle).navigation();
    }

    /**
     * 类似 Intent 的
     * startActivityForResult 跳转
     *
     * @param path
     * @param bundle
     * @param requestCode
     */

    protected void goActivityForResult(@NonNull final String path, Bundle bundle, int requestCode) {
        if (bundle == null)
            ARouter.getInstance().build(path).withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).navigation(null, requestCode);
        else
            ARouter.getInstance().build(path).with(bundle).withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).navigation(null, requestCode);
    }

    /**
     * 清理中间activity，跳转到某activity，这方法较常用
     *
     * @param path
     */
    protected void goTopActivity(@NonNull final String path) {
        ARouter.getInstance().build(path).withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).navigation();
    }

    public <T extends View> T getViewById(int id) {
        View view = findViewById(id);
        return (T) view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().finish(this);
    }

    /**
     * 抽象的设置的标题的方法 子类实现
     **/
    protected abstract String setTitle();

    /**
     * 统一的状态栏和虚拟按键颜色设置
     *
     * @return
     */
    protected abstract int getBarColorId();

}
