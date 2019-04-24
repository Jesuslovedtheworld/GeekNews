package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.activity.GoldShowActivity;
import com.example.lenovo.gmegeeknews.adapter.goldadapter.VpGoldAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.Constants;
import com.example.lenovo.gmegeeknews.bean.gold.GoldShowBean;
import com.example.lenovo.gmegeeknews.fragment.goldfragment.GoldDetailFragment;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.GoldPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.mainview.GoldView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class GoldFragment extends BaseFragment<GoldView,GoldPersenter> {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.img)
    ImageView img;
    private ArrayList<GoldShowBean> title;
    private ArrayList<Fragment> fragments;
    private final int REQUEST = 0;
    @Override
    protected GoldPersenter initPersenter() {
        return new GoldPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gold_layout;
    }

    @Override
    protected void initView() {
        initTitles();
        setFragment();
    }

    private void setFragment() {
        initFragment();
        VpGoldAdapter adapter = new VpGoldAdapter(getChildFragmentManager(), fragments, title);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }


    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < title.size(); i++) {
            GoldShowBean bean = title.get(i);
            if (bean.isChecked()){
                LogUtils.logD(GoldFragment.class,"标题"+bean.getTitles());
                GoldDetailFragment instance = GoldDetailFragment.newInstance(bean.getTitles());
                fragments.add(instance);
            }
        }
    }

    private void initTitles() {
        title = new ArrayList<>();
        title.add(new GoldShowBean(true,"Android"));
        title.add(new GoldShowBean(true,"IOS"));
        title.add(new GoldShowBean(true,"前端"));
        title.add(new GoldShowBean(true,"后端"));
        title.add(new GoldShowBean(true,"设计"));
        title.add(new GoldShowBean(true,"产品"));
        title.add(new GoldShowBean(true,"阅读"));
        title.add(new GoldShowBean(true,"工具资源"));
    }

    //点击监听
    @OnClick
    public void onClick(){
        Intent intent = new Intent(getActivity(),GoldShowActivity.class);
        intent.putExtra(Constants.LIST,title);
        startActivityForResult(intent,REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode == REQUEST && resultCode == Activity.RESULT_OK){
                 title = (ArrayList<GoldShowBean>) data.getSerializableExtra(Constants.LIST);
                LogUtils.logD(GoldFragment.class,"传回來的数据"+title.toString());
                 //todo  参数类型
                 setFragment();
            }
        }
    }
}
