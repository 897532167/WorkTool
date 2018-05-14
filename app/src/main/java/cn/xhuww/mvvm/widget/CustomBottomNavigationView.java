package cn.xhuww.mvvm.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

import java.lang.reflect.Field;

/**
 * Created by xhu_ww on 2018/5/14.
 * description: 主界面底部导航菜单，去掉展开效果
 */
public class CustomBottomNavigationView extends BottomNavigationView {
    public CustomBottomNavigationView(Context context) {
        this(context, null);
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        disableShiftMode();
    }

    @SuppressLint("RestrictedApi")
    private void disableShiftMode() {
        final BottomNavigationMenuView menuView = (BottomNavigationMenuView) getChildAt(0);
        try {
            final Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                final BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (Exception ignored) {
        }
    }
}
