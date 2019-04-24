package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.gankadapter.VpGankAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.Constants;
import com.example.lenovo.gmegeeknews.fragment.gank.GankDetaFragment;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.GankPersenter;
import com.example.lenovo.gmegeeknews.view.mainview.GankView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GankFragment extends BaseFragment<GankView, GankPersenter> {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private VpGankAdapter adapter;

    @Override
    protected GankPersenter initPersenter() {
        return new GankPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gank_layout;
    }

    @Override
    protected void initView() {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("ANDROID");
        titles.add("ISO");
        titles.add("前端");
        titles.add("福利");
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (String title : titles) {
            GankDetaFragment fragment = new GankDetaFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.TITLE,title);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        adapter = new VpGankAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}
