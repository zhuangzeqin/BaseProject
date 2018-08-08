package baseproject.demo.zzq.cn.eeepay.com.baseproject.view.viewbyid;

import android.support.annotation.IdRes;
import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述：点击事件的注解
 * 作者：zhuangzeqin
 * 时间: 2018/8/3-17:08
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Target(ElementType.METHOD)//方法上
@Retention(RetentionPolicy.CLASS)//运行时
public @interface OnClickEvent {
    @IdRes int[] value() default {View.NO_ID};//数组； 因为可能有多个按钮的点击事件
}
