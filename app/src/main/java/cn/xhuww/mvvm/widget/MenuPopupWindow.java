package cn.xhuww.mvvm.widget;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import cn.xhuww.mvvm.R;

/**
 * 作者：xhu_ww on 2018/5/3.
 * 描述：
 */
public class MenuPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    private Context context;
    private String[] menu;
    private Activity activity;

    public MenuPopupWindow(Context context, String[] menu) {
        super(context);
        this.context = context;
        this.menu = menu;
        activity = (Activity) context;
        initPopupWindow();
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_menu_popup, null);
        ListView listView = view.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.pop_spinner, R.id.tv_dialog_spinner, menu);
        listView.setAdapter(adapter);


        this.setContentView(view);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(R.style.AnimTools);
        this.setOutsideTouchable(true);
        this.setFocusable(true);
        this.setOnDismissListener(() -> {
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.alpha = 1f;
            activity.getWindow().setAttributes(lp);
        });
    }

    /**
     * 显示popupWindow在某个控件下方
     *
     * @param parent
     */
    public void showPopupWindowDown(View parent) {
        if (!this.isShowing()) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams wl = window.getAttributes();
            wl.alpha = 0.6f;   //这句就是设置窗口里崆件的透明度的．０.０全透明
            window.setAttributes(wl);
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        popupWindowItemListener.itemClick(view, position);
        this.dismiss();
    }

    public interface PopupWindowItemListener {
        void itemClick(View view, int position);
    }

    private PopupWindowItemListener popupWindowItemListener;

    public void setPopupWindowItemListener(PopupWindowItemListener popupWindowItemListener) {
        this.popupWindowItemListener = popupWindowItemListener;
    }
}
