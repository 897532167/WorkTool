package cn.xhuww.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.xhuww.mvvm.R;

/**
 * Created by xhu_ww on 2018/5/9.
 * description:左右两条线、中间文本描述
 */
public class DivisionLayoutView extends LinearLayout {
    VectorDrawableCompat drawable;
    private String text;

    public DivisionLayoutView(Context context) {
        this(context, null);
    }

    public DivisionLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DivisionLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DivisionLayoutView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.DivisionLayoutView_divisionDrawable:
                    int id = array.getResourceId(attr, -1);
                    drawable = VectorDrawableCompat.create(context.getResources(), id, context.getTheme());
                    break;
                case R.styleable.DivisionLayoutView_divisionText:
                    text = array.getString(attr);
                    break;
            }
        }
        array.recycle();
        addView(getDivisionLine(context, false));
        if (drawable != null) addView(getImageView(context));
        addView(getTextView(context));
        addView(getDivisionLine(context, true));
    }

    private View getDivisionLine(Context context, boolean isRight) {
        View view = new View(context);
        LayoutParams params = new LayoutParams(0, 1);
        params.weight = 1;
        params.leftMargin = isRight ? 5 : 15;
        if (isRight) params.rightMargin = 15;
        view.setLayoutParams(params);
        view.setBackgroundColor(Color.parseColor("#4d4d4d"));
        return view;
    }

    private ImageView getImageView(Context context) {
        ImageView view = new ImageView(context);
        view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        view.setImageDrawable(drawable);
        view.setPadding(5, 0, 3, 0);
        return view;
    }

    private TextView getTextView(Context context) {
        TextView view = new TextView(context);
        view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        view.setGravity(Gravity.CENTER);
        view.setTextSize(13);
        if (text != null) view.setText(text);
        return view;
    }
}
