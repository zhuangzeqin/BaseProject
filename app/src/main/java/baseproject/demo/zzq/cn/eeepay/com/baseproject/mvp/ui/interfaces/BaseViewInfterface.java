package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.interfaces;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * 描述：抽象出接口
 * 作者：zhuangzeqin
 * 时间: 2018/7/10-17:51
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public interface BaseViewInfterface extends EasyPermissions.PermissionCallbacks {
    /**
     * @return 布局id
     */
    int getLayoutId();

    /**
     * 初始化控件
     */
    void initView();

    /**
     * 事件绑定
     */
    void eventOnClick();
}
