package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.interfaces.BaseViewInfterface;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 描述：抽象的的Fragment
 * 作者：zhuangzeqin
 * 时间: 2018/7/19-14:36
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public abstract class BaseFragment extends Fragment implements BaseViewInfterface {
    protected Activity mContext;
    protected Bundle mBundle;
    protected View mView;

    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        initializeOnAttach(mContext);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();//参数Bunlder
    }

    /**
     * 加载初始化布局
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mView = view;
        initView();
        eventOnClick();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Logger.d("onDestroyView: ");
        if (mView != null) {
            ((ViewGroup) mView.getParent()).removeView(mView);
        }
        super.onDestroyView();
    }


    public <T extends View> T getViewById(@IdRes int id) {
        if (mView == null) throw new NullPointerException("mView is null.");
        View v = mView.findViewById(id);
        return (T) v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将请求结果传递EasyPermission库处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 关联；activity 做的初始化操作
     */
    protected abstract void initializeOnAttach(Activity activity);

}
