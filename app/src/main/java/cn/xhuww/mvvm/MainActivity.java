package cn.xhuww.mvvm;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import cn.xhuww.mvvm.view.fragment.LoginFragment;
import cn.xhuww.mvvm.view.fragment.PersonalCenterFragment;
import cn.xhuww.mvvm.view.fragment.RegisterFragment;
import cn.xhuww.mvvm.widget.CustomBottomNavigationView;
import cn.xhuww.mvvm.widget.MenuPopupWindow;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fl_main, new LoginFragment(), "LoginFragment")
//                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_main, new PersonalCenterFragment(), "PersonalCenterFragment")
                .commit();

        CustomBottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                break;
            case R.id.message:
                break;
            case R.id.timeline:
                break;
            case R.id.personal:
                break;
        }
        return true;
    }
}
