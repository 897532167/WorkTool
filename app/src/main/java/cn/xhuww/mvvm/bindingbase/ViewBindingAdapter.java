package cn.xhuww.mvvm.bindingbase;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xhu_ww on 2018/4/4.
 * description:
 */

public class ViewBindingAdapter {

    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    @BindingAdapter("isShow")
    public static void setIsShow(View view, boolean isShow) {
        if (isShow) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter({"click"})
    public static void clickCommand(View view, EventResponse response) {
        view.setOnClickListener(v -> {
            if (response != null) {
                response.execute();
            }
        });
    }

//
//    private static RecyclerView.Adapter getOrCreateAdapter(RecyclerView view) {
//        if (view.getAdapter() instanceof MultiTypeAdapter) {
//            return view.getAdapter();
//        } else {
//            final MultiTypeAdapter adapter = new MultiTypeAdapter();
//            view.setAdapter(adapter);
//            return adapter;
//        }
//    }
}
