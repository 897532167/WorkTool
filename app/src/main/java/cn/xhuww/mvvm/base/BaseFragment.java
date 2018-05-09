package cn.xhuww.mvvm.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * Created by xhu_ww on 2018/5/9.
 * description: V4包下的Fragment
 */
public abstract class BaseFragment<V extends BaseViewModel> extends Fragment {

    protected View mRootView;
    protected FragmentActivity activity;
    protected final String TAG = getClass().getName();

    @Inject
    public V viewModel;

    @Override
    public void onAttach(Context context) {
        activity = (FragmentActivity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getContext()).inflate(getLayoutRes(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "------onCreateView");
        initData();
        initView(view);
        httpRequest();
    }

    protected abstract int getLayoutRes();

    /**
     * 初始化数据，变量这些，执行位置在 initView之前
     */
    protected abstract void initData();

    protected abstract void initView(View view);

    /**
     * 网络请求
     */
    protected abstract void httpRequest();

    protected void toast(String content) {
        activity.runOnUiThread(() -> Toast.makeText(activity, content, Toast.LENGTH_SHORT).show());
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "------onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "------onDestroy");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(TAG, "------onHiddenChanged:" + hidden);
    }
}
