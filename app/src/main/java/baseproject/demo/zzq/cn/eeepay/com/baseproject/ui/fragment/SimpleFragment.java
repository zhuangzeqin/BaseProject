package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.byteam.superadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter.NullToEmptyAdapterFactory;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter.SingleAdapter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.bean.Persons;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.constant.StrDefConstant;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseFragment;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.utils.ToastUtils;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.CommonLinerRecyclerView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 描述：根据不同的标题 实例不同的Fragment
 * 作者：zhuangzeqin
 * 时间: 2018/7/19-15:16
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/fragmet/SimpleFragment")
public class SimpleFragment extends BaseFragment {
    private CommonLinerRecyclerView commonLinerRecyclerView;
    private SingleAdapter mSingleAdapter;
    private List<String> items = new ArrayList<>();
    private SmartRefreshLayout refreshLayout;

    public static SimpleFragment getInstance(@StrDefConstant.CollectionType final String title) {
        SimpleFragment sf = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_title", title);
        sf.setArguments(bundle);
        return sf;
    }

    @Override
    protected void initializeOnAttach(Activity activity) {
        items.add("logger日志打印");
        items.add("权限申请");
        items.add("奔溃异常日志记录");
        items.add("gson解析null值的问题");
        items.add("RxBus的使用");
        items.add("ConstraintLayout布局使用");
        items.add("Android注解使用");
        items.add("MVP使用");

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_simple;
    }

    @Override
    public void initView() {
        refreshLayout = getViewById(R.id.refreshLayout);
        commonLinerRecyclerView = getViewById(R.id.rv_list);
        mSingleAdapter = new SingleAdapter(mContext, items, R.layout.listitem);
        mSingleAdapter.setData(items);
        commonLinerRecyclerView.setAdapter(mSingleAdapter);
    }

    @Override
    public void eventOnClick() {
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(500);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(500);
            }
        });
        refreshLayout.setNoMoreData(true);
        mSingleAdapter.setOnlyOnce(false);
        mSingleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int viewType, int position) {
                switch (position) {
                    case 0:
                        initLoggerPrint();
                        break;
                    case 1:
                        initpermission();
                        break;
                    case 2:
                        ARouter.getInstance().build("/activity/ErrorActivity").
                                withTransition(R.anim.eposp_push_left_in, R.anim.eposp_push_left_out).
                                withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                        Intent.FLAG_ACTIVITY_NEW_TASK).
                                withString("message", "test 一下，这里有一个异常页面；显示异常信息 ").
                                navigation();
                        break;
                    case 3:
                        String json = "{\"careingpeople_id\":\"33\",\"lovecode\":null,\"appellation\":\"父亲\",\"name\":\"王健林\",\"birthday\":\"2015-04-08\",\"mobile\":\"15689653698\",\"areano\":\"320583\",\"communityno\":\"1\",\"communityname\":\"测试小区\",\"agency_id\":\"1\",\"street\":\"\",\"sex\":null,\"canselfcare\":\"0\",\"language\":\"本地话\",\"disease\":\"糖尿病\",\"memo\":\"哈哈\",\"price\":null,\"ctime\":null}";
                        Gson gson = new GsonBuilder().
                                registerTypeAdapterFactory(new NullToEmptyAdapterFactory())
                                .create();
                        //然后用上面一行写的gson来序列化和反序列化实体类type
                        Persons persons = gson.fromJson(json, Persons.class);
                        Logger.json(json);
                        Logger.d(persons.toString());
                        break;
                    case 4:
                        SparseArray<String> stringSparseArray = new SparseArray<>();
//                        SparseBooleanArray
//                        SparseIntArray
//                        SparseLongArray
//                        LongSparseArray
//                        ArrayMap arrayMap = new ArrayMap<>()
                        ARouter.getInstance().build("/Rx/RxBusAct").navigation();
                        break;
                    case 5:
                        ARouter.getInstance().build("/test/ConstraintLayoutActivity").navigation();
                        break;
                    case 6:
                        ARouter.getInstance().build("/annoteted/AnnotatedAct").navigation();
                        break;
                    case 7:
                        ARouter.getInstance().build("/mvp/TestMVPAct2").navigation();
                        break;
                }
            }
        });
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

    private void initLoggerPrint() {
        Logger.d("I'm a log which you don't see easily, hehe");
        Logger.d("hello %s", "world");//可以打印占位符
        Logger.t("tag").e("Custom tag for only one use");
        Logger.json("{ \"key\": 3, \"value\": something}");
        Logger.xml("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<resources>\n" +
                "    <color name=\"colorPrimary\">#3F51B5</color>\n" +
                "    <color name=\"colorPrimaryDark\">#303F9F</color>\n" +
                "    <color name=\"colorAccent\">#FF4081</color>\n" +
                "    <color name=\"unify_txt_color_ff7e00\">#ff7e00</color>\n" +
                "    <color name=\"white\">#ffffffff</color>\n" +
                "    <color name=\"black\">#FF000000</color>\n" +
                "    <color name=\"eposp_red_2\">#ee4040</color>\n" +
                "</resources>");
        Logger.d(Arrays.asList("foo", "bar"));//打印List
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value2");
        Logger.d(map);//打印map
    }
}
