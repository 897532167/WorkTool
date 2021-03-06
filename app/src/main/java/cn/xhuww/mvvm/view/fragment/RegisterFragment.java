package cn.xhuww.mvvm.view.fragment;

import android.view.View;

import cn.xhuww.mvvm.R;
import cn.xhuww.mvvm.base.BaseFragment;
import cn.xhuww.mvvm.base.BaseViewModel;
import cn.xhuww.mvvm.view.dialog.DialogLoading;

/**
 * Created by xhu_ww on 2018/5/9.
 * description:用户注册界面
 */
public class RegisterFragment extends BaseFragment<BaseViewModel> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        DialogLoading dialog = new DialogLoading(activity);
        dialog.showDialog();
    }

    @Override
    protected void httpRequest() {

    }
}
