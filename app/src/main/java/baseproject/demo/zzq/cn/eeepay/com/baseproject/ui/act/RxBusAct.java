package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.orhanobut.logger.Logger;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseFitsSystemWindowsActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.RxBus;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import rx.Observable;
import rx.functions.Action1;

/**
 * 描述：RxBus 的使用
 * 作者：zhuangzeqin
 * 时间: 2018/7/27-11:55
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/Rx/RxBusAct")
public class RxBusAct extends BaseFitsSystemWindowsActivity implements Action1<String> {
    String tag = "tag";
    Observable<String> ob;
    private TextView msg;

    @Override
    protected String setTitle() {
        return "RxBus的使用";
    }

    @Override
    protected int getBarColorId() {
        return R.color.btn_color_pre;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rxbusact;
    }

    @Override
    public void initView() {
        //创建被观察者
        ob = RxBus.getInstance().register(tag);
        //订阅观察事件
        ob.subscribe(this);
        getViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送内容
                RxBus.getInstance().post(tag, "我是内容");
            }
        });
        msg = getViewById(R.id.tv_msg);
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

    @Override
    protected void onDestroy() {
        RxBus.getInstance().unregister(tag, ob);
        super.onDestroy();
    }

    @Override
    public void call(String s) {
        Logger.d(s);
        ToastUtils.showLong(s);
        msg.setText(s);
    }
}
