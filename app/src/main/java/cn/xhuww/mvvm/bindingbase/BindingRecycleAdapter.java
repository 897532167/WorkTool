package cn.xhuww.mvvm.bindingbase;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by xhu_ww on 2018/4/4.
 * description:
 */

public class BindingRecycleAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
