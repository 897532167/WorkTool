package cn.xhuww.mvvm;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import cn.xhuww.mvvm.widget.MenuPopupWindow;

public class MainActivity extends AppCompatActivity {

    String[] strs = new String[]{"測試1", "測試2", "測試13", "測試4", "測試5", "測試6", "測試6", "測試6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rlToolbar = findViewById(R.id.toolbar);
        TextView textView = findViewById(R.id.tv_right_handle);
        textView.setOnClickListener(v -> {
            MenuPopupWindow popupWindow = new MenuPopupWindow(this, strs);
            popupWindow.showAsDropDown(rlToolbar);
        });
    }
}
