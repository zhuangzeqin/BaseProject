package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter.SingleAdapter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.recyclerview.CommonLinerRecyclerView;

@Route(path = "/activity/StickyScrollViewActivity")
public class StickyScrollViewActivity extends Activity {
    CommonLinerRecyclerView commonLinerRecyclerView;
    private SingleAdapter mSingleAdapter;
    private List<String> items = new ArrayList<>();
     SmartRefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_scroll_view);
        commonLinerRecyclerView = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        initView();
    }


    private void initView() {
        for (int i=0;i<25;i++)
        {
            items.add("内容"+i);
        }
        mSingleAdapter = new SingleAdapter(this, items, R.layout.listitem);
        commonLinerRecyclerView.setAdapter(mSingleAdapter);
    }

}
