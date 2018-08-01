package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject._tab.AbstractCommonTabLayout;

/**
 * 描述：基础的项目架构
 * 作者：zhuangzeqin
 * 时间: 2018/7/10-14:19
 * 邮箱：zzq@eeepay.cn
 */
public class MainActivity extends AbstractCommonTabLayout {
    private String[] mTitles = {"首页", "会员", "海报", "我的"};//标题
    private ArrayList<Fragment> mFragments = new ArrayList<>();//Fragment 集合
    private int[] mIconUnselectIds = {
            R.mipmap.homepage_nor,
            R.mipmap.agency_nor,
            R.mipmap.poster_nor,
            R.mipmap.user_nor
    };//未选中

    private int[] mIconSelectIds = {
            R.mipmap.homepage_sel,
            R.mipmap.agency_sel,
            R.mipmap.poster_sel,
            R.mipmap.user_sel
    };//选中

    /**
     * 标题数组
     **/
    @Override
    protected String[] getTitles() {
        return mTitles;
    }

    /**
     * 选择图标数组
     **/
    @Override
    protected int[] getIconSelectIds() {
        return mIconSelectIds;
    }

    /**
     * 未选择图标数组
     **/
    @Override
    protected int[] getIconUnselectIds() {
        return mIconUnselectIds;
    }


    /**
     * Fragment 集合 首页 "代理", "海报", "我的"
     **/
    @Override
    protected ArrayList<Fragment> getFragmentList() {
        // 获取Fragment
        Fragment fragment1 = (Fragment) ARouter.getInstance().build("/fragmet/SimpleFragment").navigation();
        Fragment fragment2 = (Fragment) ARouter.getInstance().build("/mvp/TestMVPFragment").navigation();
        Fragment fragment3 = (Fragment) ARouter.getInstance().build("/fragmet/SimpleFragment").navigation();
        Fragment fragment4 = (Fragment) ARouter.getInstance().build("/fragmet/SimpleFragment").navigation();
        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);
/*        mFragments.add(SimpleFragment.getInstance(StrDefConstant.KEY_BAODAN));//添加首页
        //后续可以添加其他的Fragment 这里我用同一个Fragment
        mFragments.add(SimpleFragment.getInstance(StrDefConstant.KEY_FENSI));//添加会员
        mFragments.add(SimpleFragment.getInstance(StrDefConstant.KEY_DAILI));//添加海报
        mFragments.add(SimpleFragment.getInstance(StrDefConstant.KEY_PTYH));//添加我的*/
        return mFragments;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    /**
     * CommonTabLayout 资源id
     **/
    @Override
    protected int getCommonTabLayout() {
        return R.id.tl_2;
    }

    /**
     * ViewPager 资源id
     **/
    @Override
    protected int getCommonViewPager() {
        return R.id.vp_2;
    }

    @Override
    protected String setTitle() {
        return "Tab 通用框架";
    }

    @Override
    protected int getBarColorId() {
        return R.color.unify_txt_color_ff7e00;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
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
