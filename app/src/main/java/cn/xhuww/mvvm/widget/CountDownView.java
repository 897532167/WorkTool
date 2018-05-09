package cn.xhuww.mvvm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;

/**
 * Created by xhu_ww on 2018/5/9.
 * description:倒计时View
 */
public class CountDownView extends AppCompatTextView implements Runnable {
    private boolean run = false;
    private String endHint;
    private int count;
    private boolean isCanRun;

    public CountDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CountDownView(Context context) {
        super(context);
    }

    /**
     * 设置倒计完成时的显示提示
     *
     * @param endHint
     */
    public void setEndHint(String endHint) {
        this.endHint = endHint;
    }

    public boolean isRun() {
        return run;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void stopRun() {
        this.run = false;
    }

    public void startRun() {
        this.run = true;
        run();
    }

    @Override
    public void run() {
        if (run && count > 0) {
            this.setText(count + "s");
            postDelayed(this, 1000);
            count--;
        } else {
            run = false;
            if (endHint != null) {
                this.setText(endHint);
            } else {
                this.setText("0s");
            }
        }
    }
}