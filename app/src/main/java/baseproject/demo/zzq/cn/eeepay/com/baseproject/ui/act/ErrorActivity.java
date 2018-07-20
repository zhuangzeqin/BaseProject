package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.base.BaseFitsSystemWindowsActivity;

/**
 * 描述：debug情况下发生异常跳转的界面
 * 作者：zhuangzeqin
 * 时间: 2018/7/12-15:52
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class ErrorActivity extends BaseFitsSystemWindowsActivity {
    TextView cashError;
    Button btnOk;

    public static void show(Context context, String message) {
        if (message == null)
            return;
        Intent intent = new Intent(context, ErrorActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("message", message);
        context.startActivity(intent);
    }

    @Override
    protected String setTitle() {
        return "异常页面";
    }

    @Override
    protected int getBarColorId() {
        return R.color.eposp_red_2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_error;
    }

    @Override
    public void initView() {
//        mToolbar.setBackgroundColor(getResources().getColor(R.color.eposp_red_2));//颜色设置
        cashError = getViewById(R.id.tv_crash_info);
        btnOk = getViewById(R.id.btn_restart);
        cashError.setText(getIntent().getStringExtra("message"));
    }


    @Override
    public void eventOnClick() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}
