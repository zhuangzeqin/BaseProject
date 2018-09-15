package baseproject.demo.zzq.cn.eeepay.com.baseproject.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.MainActivity;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2018/8/28-11:21
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//API需要在21及以上
public class MyJobService extends JobService{
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(MyJobService.this, "MyJobService", Toast.LENGTH_SHORT).show();
            JobParameters param = (JobParameters) msg.obj;
            jobFinished(param, true);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
    });

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        //TODO 写上你的任务逻辑代码
        Message m = Message.obtain();
        m.obj = jobParameters;
        handler.sendMessage(m);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        handler.removeCallbacksAndMessages(null);
        return false;
    }
}
