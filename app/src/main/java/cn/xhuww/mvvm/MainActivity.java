package cn.xhuww.mvvm;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import cn.xhuww.mvvm.view.fragment.RegisterFragment;
import cn.xhuww.mvvm.widget.MenuPopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_main, new RegisterFragment(), "RegisterFragment")
                .commit();
    }
}
