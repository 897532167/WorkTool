package cn.xhuww.mvvm.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.xhuww.mvvm.R;
import cn.xhuww.mvvm.base.BaseFragment;
import cn.xhuww.mvvm.base.BaseViewModel;
import cn.xhuww.mvvm.model.ContactBean;
import cn.xhuww.mvvm.view.adapter.ContactListAdapter;
import cn.xhuww.mvvm.widget.SectionItemDecoration;
import cn.xhuww.mvvm.widget.SideIndexBar;

/**
 * Created by xhu_ww on 2018/5/14.
 * description:
 */
public class ContactFragment extends BaseFragment<BaseViewModel> implements SideIndexBar.OnIndexTouchedChangedListener {

    List<ContactBean> contactBeanList = new ArrayList<>();
    private ContactListAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initData() {
        contactBeanList.add(new ContactBean("A", "AERTR"));
        contactBeanList.add(new ContactBean("A", "AERTR"));
        contactBeanList.add(new ContactBean("A", "AERTR"));
        contactBeanList.add(new ContactBean("C", "CERTR"));
        contactBeanList.add(new ContactBean("C", "CERTR"));
        contactBeanList.add(new ContactBean("C", "CERTR"));
        contactBeanList.add(new ContactBean("F", "FERTR"));
        contactBeanList.add(new ContactBean("F", "FERTR"));
        contactBeanList.add(new ContactBean("G", "GERTR"));
        contactBeanList.add(new ContactBean("G", "GERTR"));
        contactBeanList.add(new ContactBean("H", "HERTR"));
        contactBeanList.add(new ContactBean("H", "HERTR"));
        contactBeanList.add(new ContactBean("H", "HERTR"));
        contactBeanList.add(new ContactBean("J", "JERTR"));
        contactBeanList.add(new ContactBean("J", "JERTR"));
        contactBeanList.add(new ContactBean("K", "KERTR"));
        contactBeanList.add(new ContactBean("K", "KERTR"));
        contactBeanList.add(new ContactBean("L", "LERTR"));
        contactBeanList.add(new ContactBean("W", "WERTR"));
        contactBeanList.add(new ContactBean("W", "WERTR"));
        contactBeanList.add(new ContactBean("W", "WERTR"));
        contactBeanList.add(new ContactBean("X", "XERTR"));
        contactBeanList.add(new ContactBean("X", "XERTR"));
        contactBeanList.add(new ContactBean("X", "XERTR"));
        contactBeanList.add(new ContactBean("Y", "YERTR"));
        contactBeanList.add(new ContactBean("Y", "YERTR"));
        contactBeanList.add(new ContactBean("Y", "YERTR"));
        contactBeanList.add(new ContactBean("Y", "YERTR"));
        contactBeanList.add(new ContactBean("Z", "ZERTR"));
        contactBeanList.add(new ContactBean("Z", "ZERTR"));
        contactBeanList.add(new ContactBean("Z", "ZERTR"));
        contactBeanList.add(new ContactBean("Z", "ZERTR"));

        adapter = new ContactListAdapter(activity, contactBeanList);
    }

    @Override
    protected void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.contact_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SectionItemDecoration(getActivity(), contactBeanList), 0);
        adapter.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        TextView mOverlayTextView = view.findViewById(R.id.cp_overlay);
        SideIndexBar sideIndexBar = view.findViewById(R.id.side_index_bar);
        sideIndexBar.setOverlayTextView(mOverlayTextView).setOnIndexChangedListener(this);
    }

    @Override
    protected void httpRequest() {

    }

    @Override
    public void onIndexChanged(String index, int position) {
        //滚动RecyclerView到索引位置
        adapter.scrollToSection(index);
    }
}
