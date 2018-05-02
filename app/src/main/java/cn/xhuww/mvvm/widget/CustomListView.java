package cn.xhuww.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.xhuww.mvvm.R;


/**
 * 作者：xhu_ww on 2018/5/3.
 * 描述：
 */

public class CustomListView extends LinearLayout {
    private int textNormalColor;
    private int textSelectColor;
    private int textBackNormalColor;
    private int textBackSelectColor;
    private Drawable drawableLeft;
    private OnItemClickListener listener;
    private int lastItem = -1;

    public CustomListView(Context context) {
        this(context, null);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomListView, defStyleAttr, 0);
        for (int i = 0; i < array.length(); i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.CustomListView_textNormalColor:
                    textNormalColor = array.getColor(attr, Color.parseColor("#cccccc"));
                    break;
                case R.styleable.CustomListView_textSelectColor:
                    textSelectColor = array.getColor(attr, Color.parseColor("#ff0000"));
                    break;
                case R.styleable.CustomListView_textBackNormalColor:
                    textBackNormalColor = array.getColor(attr, Color.parseColor("#ffffff"));
                    break;
                case R.styleable.CustomListView_textBackSelectColor:
                    textBackSelectColor = array.getColor(attr, Color.parseColor("#cccccc"));
                    break;
                case R.styleable.CustomListView_drawableLeft:
                    drawableLeft = array.getDrawable(attr);
                    break;
            }
        }
        array.recycle();
    }

    public void setItem(List<String> names) {
        if (names == null) return;
        for (int i = 0; i < names.size(); i++) {
            this.addView(getChild(names.get(i), i));
        }
    }

    private TextView getChild(String name, int position) {
        TextView child = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_left_menu_listview, this, false);
        child.setText(name);
        child.setOnClickListener(v -> {
            if (position != lastItem) {
                setTextViewBackground((TextView) getChildAt(lastItem), false);
                setTextViewBackground((TextView) v, true);
                lastItem = position;
                if (listener != null) listener.onItemClick(position);
            }
        });
//		if (position==0) {
//			lastItem=0;
//			setTextViewBackground( child, true);
//		}
        return child;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (lastItem == -1 && this.getChildCount() > 0) {
            lastItem = 0;
            setTextViewBackground((TextView) this.getChildAt(0), true);
        }
    }

    private void setTextViewBackground(TextView v, boolean hasFocus) {
        if (hasFocus) {
            v.setBackgroundColor(textBackSelectColor);
            if (drawableLeft != null) {
                drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), v.getMeasuredHeight() - 20);
                v.setCompoundDrawables(drawableLeft, null, null, null);
                v.setCompoundDrawablePadding(15);
            }
            v.setTextColor(textSelectColor);
        } else {
            v.setBackgroundColor(textBackNormalColor);
            v.setCompoundDrawables(null, null, null, null);
            v.setCompoundDrawablePadding(0);
            v.setTextColor(textNormalColor);
        }
    }

    public void setonItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

