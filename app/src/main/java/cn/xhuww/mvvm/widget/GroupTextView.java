package cn.xhuww.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.xhuww.mvvm.R;

/**
 * Created by xhu_ww on 2018/5/14.
 * description:TextView组合控件
 */
public class GroupTextView extends LinearLayout {

    private TextView leftTextView;
    private TextView rightTextView;
    private int leftTextColor;
    private int rightTextColor;
    private int leftTextSize;
    private int rightTextSize;
    private int rightDrawable;
    private int leftDrawable;
    private String leftText;
    private String rightText;
    private int leftDrawablePadding;
    private int rightDrawablePadding;
    private int leftWidth;
    public GroupTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.GroupTextView,defStyleAttr,0);
        for (int i=0;i<array.getIndexCount();i++){
            int attr=array.getIndex(i);
            switch (attr){
                case R.styleable.GroupTextView_textLeftString:
                    leftText=array.getString(attr);
                    break;
                case R.styleable.GroupTextView_textRightString:
                    rightText=array.getString(attr);
                    break;
                case R.styleable.GroupTextView_textLeftSize:
                    leftTextSize= (int) (array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()))/getResources().getDisplayMetrics().density);
                    break;
                case R.styleable.GroupTextView_textRightSize:
                    rightTextSize= (int) (array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()))/getResources().getDisplayMetrics().density);
                    break;
                case R.styleable.GroupTextView_textLeftColor:
                    leftTextColor=array.getColor(attr, Color.parseColor("#272636"));
                    break;
                case R.styleable.GroupTextView_textRightColor:
                    rightTextColor=array.getColor(attr, Color.parseColor("#272636"));
                    break;
                case R.styleable.GroupTextView_leftDrawable:
                    leftDrawable=array.getResourceId(attr,0);
                    break;
                case R.styleable.GroupTextView_rightDrawable:
                    rightDrawable=array.getResourceId(attr,0);
                    break;
                case R.styleable.GroupTextView_drawablePaddingLeft:
                    leftDrawablePadding=array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.GroupTextView_drawablePaddingRight:
                    rightDrawablePadding=array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.GroupTextView_leftWidth:
                    leftWidth=array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
                    break;
            }
        }
        array.recycle();
        LayoutInflater.from(context).inflate(R.layout.layout_custom_group_text, this, true);
        initView();
    }
    public GroupTextView(Context context) {
        this(context, null);
    }

    /**
     * 在填充完成后找到textView组件
     */
    protected void initView() {
        this.leftTextView= (TextView) findViewById(R.id.group_left_view);
        this.rightTextView= (TextView) findViewById(R.id.group_right_view);
        if (leftWidth!=0) {
            LayoutParams params= (LayoutParams) leftTextView.getLayoutParams();
            params.width=leftWidth;
            leftTextView.setLayoutParams(params);
        }
        setLeftTextViewProperty();
        setRightTextViewProperty();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isClickable()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    setBackgroundColor(Color.parseColor("#efefef"));
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    setBackgroundColor(Color.parseColor("#ffffff"));
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    public void setLeftViewText(String text){
        leftTextView.setText(text);
    }
    public String getLeftText(){
        return leftTextView.getText().toString();
    }
    public void setRightTextView(String text){
        rightTextView.setText(text);
    }
    public void setRightDrawable(Drawable drawable){
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        rightTextView.setCompoundDrawables(null,null,drawable,null);
        rightTextView.setCompoundDrawablePadding(rightDrawablePadding);
    }

    /**
     * 设置左边TextView的属性
     */
    private void setLeftTextViewProperty(){
        if (leftDrawable!=0){
            Drawable drawable=getContext().getResources().getDrawable(leftDrawable);
            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            leftTextView.setCompoundDrawables(drawable,null,null,null);
            leftTextView.setCompoundDrawablePadding(leftDrawablePadding);
        }
        leftTextView.setTextColor(leftTextColor == 0 ? Color.parseColor("#272636") : leftTextColor);
        leftTextView.setTextSize(leftTextSize == 0 ? 15 : leftTextSize);
        if (leftText!=null) leftTextView.setText(leftText);
    }

    /**
     * 设置右边TextView的属性
     */
    private void setRightTextViewProperty(){
        if (rightText!=null) rightTextView.setText(rightText);
        if (rightDrawable!=0){
            Drawable drawable=getContext().getResources().getDrawable(rightDrawable);
            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            rightTextView.setCompoundDrawables(null,null,drawable,null);
            rightTextView.setCompoundDrawablePadding(rightDrawablePadding);
        }
        rightTextView.setTextColor(rightTextColor==0? Color.parseColor("#272636"):rightTextColor);
        rightTextView.setTextSize(rightTextSize==0?15:rightTextSize);
    }
}
