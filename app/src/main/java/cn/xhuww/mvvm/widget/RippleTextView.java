package cn.xhuww.mvvm.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.support.v7.widget.AppCompatTextView;

/**
 * Created by xhu_ww on 2018/5/9.
 * description:水波纹效果 TextView
 */
public class RippleTextView extends AppCompatTextView {
    //画笔
    private Paint mPaint;
    //波纹的中心点
    private PointF centPoint;
    //波纹初始半径
    private int initRadius;
    private float maxRadius;
    //用于判断是否接收up事件
    private boolean isPressed;
    private boolean isShowRipple;

    public RippleTextView(Context context) {
        this(context, null);
    }

    public RippleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        isShowRipple = Build.VERSION.SDK_INT >= 18;
    }

    private void setCentPoint(float x, float y) {
        if (isShowRipple) {
            this.centPoint = new PointF(x, y);
            if (mPaint == null) {
                mPaint = new Paint();
                mPaint.setAntiAlias(true);
                mPaint.setAlpha(40);
                mPaint.setStyle(Paint.Style.FILL);
            }
            initRadius = 0;
            maxRadius = x >= getWidth() / 2 ? x : getWidth() - x;
            invalidate();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (isShowRipple) {
            if (event.getAction() == MotionEvent.ACTION_UP && !isPressed) {
                isPressed = true;
                setCentPoint(event.getX(), event.getY());
                //先让up事件吊起，当波纹动作完成后再传up事件
                postDelayed(new DispatchUpTouchEventRunnable(event), (long) (maxRadius / 20) * 10 + 400);
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                isPressed = false;
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (centPoint != null && isShowRipple) {
            if ((initRadius += 20) <= maxRadius) {
                canvas.drawCircle(centPoint.x, centPoint.y, initRadius, mPaint);
            } else {
                centPoint = null;
            }
            postInvalidateDelayed(10);
        }
    }

    class DispatchUpTouchEventRunnable implements Runnable {
        public MotionEvent event;

        public DispatchUpTouchEventRunnable(MotionEvent event) {
            this.event = event;
        }

        @Override
        public void run() {
            RippleTextView.this.dispatchTouchEvent(event);
        }
    }
}
