package baseproject.demo.zzq.cn.eeepay.com.baseproject.ui.act;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.constant.LongDefConstant;

/**
 * 描述：android 注解框架
 * IntDef和StringDef注解；
 * <p>
 * 资源类型注解；
 * <p>
 * Null注解；
 * <p>
 * 其他实用注解
 * 作者：zhuangzeqin
 * 时间: 2018/7/30-17:33
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/annoteted/AnnotatedAct")
public class AnnotatedAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotated);
//        initString(null);
//        initString("1");
//        initString("123");
//        initString("1234567891");
//
//        initString(R.string.app_name,1);
//        initString(R.string.app_name,3.5f);
//        initString(R.style.AppTheme,6);
//        initString(1,0);
//
//        intiLong(2);
//        intiLong(LongDefConstant.MONDAY);

//        testDo(R.string.app_name);
//        getCount()


    }


    private void initString(@Size(min = 5, max = 10) @NonNull String str) {
        com.orhanobut.logger.Logger.d(str);
    }

    private void initString(@StringRes int st, @IntRange(from = 2) int count) {
        com.orhanobut.logger.Logger.d(st);
    }

    private void initString(@StringRes int st, @FloatRange(from = 3.0, to = 10.0) Float count) {
        com.orhanobut.logger.Logger.d(st);
    }

    private void intiLong(@LongDefConstant.WeekDays long week) {

    }

    @WorkerThread
    private void testDo(@StringRes int st)
    {
        com.orhanobut.logger.Logger.d("aaaaaaaaaaaaaa");
    }
    @UiThread
    private void testDo2(@StringRes int st)
    {
        com.orhanobut.logger.Logger.d("aaaaaaaaaaaaaa");
    }
    @MainThread
    private void testDo3(@StringRes int st)
    {
        com.orhanobut.logger.Logger.d("aaaaaaaaaaaaaa");
    }
    
    @CheckResult
    private int getCount()
    {
        return 0;
    }



//    @UiThread： UI线程
//
//    @MainThread ：主线程
//
//    @WorkerThread： 子线程
//
//    @BinderThread ： 绑定线程


}
