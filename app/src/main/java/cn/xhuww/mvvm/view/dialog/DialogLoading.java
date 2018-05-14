package cn.xhuww.mvvm.view.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import cn.xhuww.mvvm.R;

/**
 * Created by xhu_ww on 2018/5/14.
 * description:加载 对话框
 */
public class DialogLoading extends ProgressDialog {
    private TextView textView;
    private AVLoadingIndicatorView mAVLoadingIndicatorView;

    public DialogLoading(@NonNull Context context) {
        this(context, R.style.WaiProgressDialog);
    }

    public DialogLoading(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

//    protected DialogLoading(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
//        super(context, cancelable, cancelListener);
//    }

    public void showDialog(String prompt) {
        initDialog();
        if (prompt != null) {
            textView.setText(prompt);
        }
    }

    public void showDialog() {
        initDialog();
    }

    public void setPrompt(String prompt) {
        if (prompt != null) {
            textView.setText(prompt);
        }
    }

    private void initDialog() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        show();
        setContentView(R.layout.dialog_loading);
        textView = findViewById(R.id.loading_text);
        mAVLoadingIndicatorView = findViewById(R.id.loading_process);
        mAVLoadingIndicatorView.show();
    }
}
