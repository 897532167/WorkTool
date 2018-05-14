package cn.xhuww.mvvm.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.xhuww.mvvm.R;
import cn.xhuww.mvvm.model.ContactBean;

/**
 * Created by xhu_ww on 2018/5/14.
 * description:联系人 Adapter
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.BaseViewHolder> {

    private Context mContext;
    private List<ContactBean> mData;
    private LinearLayoutManager mLayoutManager;
    private boolean stateChanged;

    public ContactListAdapter(Context context, List<ContactBean> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contact_recycle_item_default, parent, false);
        return new DefaultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        final int pos = holder.getAdapterPosition();
        final ContactBean data = mData.get(pos);
        if (data == null) {
            return;
        }
        ((DefaultViewHolder) holder).name.setText(data.getName());
        ((DefaultViewHolder) holder).name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mInnerListener != null) {
//                    mInnerListener.dismiss(pos, data);
//                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setLayoutManager(LinearLayoutManager manager){
        this.mLayoutManager = manager;
    }

    /**
     * 滚动RecyclerView到索引位置
     *
     * @param index
     */
    public void scrollToSection(String index) {
        Log.i("TAG", "-------------" + index);

        if (mData == null || mData.isEmpty()) return;
        if (TextUtils.isEmpty(index)) return;
        int size = mData.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(index.substring(0, 1), mData.get(i).getSection().substring(0, 1))) {
                if (mLayoutManager != null) {
                    mLayoutManager.scrollToPositionWithOffset(i, 0);
                    if (TextUtils.equals(index.substring(0, 1), "定")) {
                        //防止滚动时进行刷新
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (stateChanged) notifyItemChanged(0);
                            }
                        }, 1000);
                    }
                    return;
                }
            }
        }
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class DefaultViewHolder extends BaseViewHolder {
        TextView name;

        DefaultViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cp_list_item_name);
        }
    }
}
