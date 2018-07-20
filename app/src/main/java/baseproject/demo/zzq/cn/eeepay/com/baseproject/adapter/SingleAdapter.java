package baseproject.demo.zzq.cn.eeepay.com.baseproject.adapter;

import android.content.Context;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import baseproject.demo.zzq.cn.eeepay.com.baseproject.R;

/**
 * 描述：一个简单的万能适配器SuperAdapter
 * 作者：zhuangzeqin
 * 时间: 2018/7/17-10:42
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class SingleAdapter extends SuperAdapter<String> {
    public SingleAdapter(Context context, List<String> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, String item) {
        holder.setText(R.id.tv_name, item);
    }

    /**
     *，ListView 多布局的情况下
     * 因为getViewTypeCount()方法仅在使用ListView、GridView等控件时是必须提供的:
     * @return
     */
    /*@Override
    protected IMulItemViewType<String> offerMultiItemViewType() {
        return new IMulItemViewType<String>() {
            *//**
     * getViewTypeCount()方法仅在使用ListView、GridView等控件时是必须提供的:
     * @return
     *//*
            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, String mockModel) {
                if (position % 2 == 0) {
                    return 0;
                }
                return 1;
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 0) {
                    return 1;
                }
                return 2;
            }
        };
    }*/

    /**
     * RecyclerView 多布局的情况下
     * 使用的是RecyclerView，在使用多布局时，还可以使用SimpleMulItemViewType类（继承自IMulItemViewType）
     * @return
     */
  /*  @Override
    protected IMulItemViewType<String> offerMultiItemViewType() {
        return new SimpleMulItemViewType<String>() {
            @Override
            public int getItemViewType(int position, String s) {
                if (position % 2 == 0) {
                        return 0;
                    }
                    return 1;
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 0) {
                    return R.layout.item_type1;
                }
                    return R.layout.item_type2;
            }
        };
    }*/
}
