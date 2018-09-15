package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.base.BaseMvpActivity;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.service.MyJobService;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述：JobScheduler是android 5.0提供的一个API，
 * 可以指定一段时间循环执行特定的任务，这些任务都会被系统统一调度执行
 * 作者：zhuangzeqin
 * 时间: 2018/8/28-11:05
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@Route(path = "/job/JobSchedulerActivity")
public class JobSchedulerActivity extends BaseMvpActivity {
    @BindView(R.id.btn_open)
    Button btn_opend;

    @Override
    protected int getContentView() {
        return R.layout.activity_job_scheduler;
    }

    @Override
    protected String setTitle() {
        return "JobScheduler基础使用";
    }

    @Override
    protected void initView() {
        initBgBar(R.color.eposp_red_2);
    }

    @Override
    protected void eventOnClick() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.btn_open)
    public void setOnclick(View view) {
    // jobId每个Job任务的id
        int jobId = 1;
    // 指定你需要执行的JobService
        ComponentName name = new ComponentName(getPackageName(), MyJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(jobId, name);
        ////不管是否有网络这个任务都会被执行
        //JobInfo.NETWORK_TYPE_NONE
        ////任意一种网络任务可以执行
        //JobInfo.NETWORK_TYPE_ANY
        ////它表示设备在WIFI连接时任务才会被执行
        //JobInfo.NETWORK_TYPE_UNMETERED
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY); //设置需要的网络条件，默认NETWORK_TYPE_NONE
//        if (Build.VERSION.SDK_INT >= 24) {
//            builder.setMinimumLatency(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS); //执行的最小延迟时间
//            builder.setOverrideDeadline(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);  //执行的最长延时时间
//            builder.setMinimumLatency(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
//            builder.setBackoffCriteria(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS, JobInfo.BACKOFF_POLICY_LINEAR);//线性重试方案
//        } else {
//            builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
//        }
        builder.setMinimumLatency(3000);// 设置任务运行最少延迟时间
        builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);//设置间隔时间
        builder.setOverrideDeadline(50000);// 设置deadline，若到期还没有达到规定的条件则会开始执行
        builder.setRequiresCharging(true);// 设置是否充电的条件,默认false
        builder.setRequiresDeviceIdle(false);// 设置手机是否空闲的条件,默认false
        builder.setPersisted(true);//设备重启之后你的任务是否还要继续执行
        JobInfo info = builder.build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
//            jobScheduler.cancelAll();
//            JobInfo jobInfo = new JobInfo.Builder(1, new ComponentName(getPackageName(), MyJobService.class.getName()))
//                    .setPeriodic(2000)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//                    .build();
            int schedule = jobScheduler.schedule(info);
            if (schedule <= 0) {
                Log.w(TAG, "schedule error！");
            }
        }
    }

    @Override
    protected void initData() {

    }
}
