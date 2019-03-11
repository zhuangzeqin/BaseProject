package baseproject.demo.zzq.cn.eeepay.com.baseproject.mvp.ui.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter.SingleAdapter;
import baseproject.demo.zzq.cn.eeepay.com.baseproject.view.recyclerview.CommonLinerRecyclerView;
@Route(path = "/RxJava/CoordinatorLayoutActivity")
public class CoordinatorLayoutActivity extends AppCompatActivity {
    private SingleAdapter mSingleAdapter;
    private List<String> items = new ArrayList<>();
    private SmartRefreshLayout refreshLayout;
    private CommonLinerRecyclerView commonLinerRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        initData();
        refreshLayout = (SmartRefreshLayout) this.findViewById(R.id.refreshLayout);
        commonLinerRecyclerView = (CommonLinerRecyclerView) this.findViewById(R.id.rv_list);
        mSingleAdapter = new SingleAdapter(this, items, R.layout.listitem);
        mSingleAdapter.setData(items);
        commonLinerRecyclerView.setAdapter(mSingleAdapter);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(500);
                initData();
                mSingleAdapter.addAll(items);

            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(500);
                initData();
                mSingleAdapter.addAll(items);
            }
        });
//        refreshLayout.setNoMoreData(true);
    }

   private void initData()
   {
       for (int i=0;i<15;i++)
       {
           items.add(String.valueOf(i));
       }
   }

}
