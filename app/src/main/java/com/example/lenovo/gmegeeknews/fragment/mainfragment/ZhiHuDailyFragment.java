package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.mainadapter.VpZhiHuAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.fragment.zhihufragment.ColumnFragment;
import com.example.lenovo.gmegeeknews.fragment.zhihufragment.DailyFragment;
import com.example.lenovo.gmegeeknews.fragment.zhihufragment.HotFragment;
import com.example.lenovo.gmegeeknews.fragment.zhihufragment.ThemeFragment;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.ZhiHuPersenter;
import com.example.lenovo.gmegeeknews.view.mainview.ZhuHuView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHuDailyFragment extends BaseFragment<ZhuHuView, ZhiHuPersenter> {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;

    @Override
    protected int getLayoutId() {
        return R.layout.zhuhu_login;
    }

    @Override
    protected ZhiHuPersenter initPersenter() {
        return new ZhiHuPersenter();
    }

    @Override
    protected void initView() {
            initFragment();
            initTitles();
        VpZhiHuAdapter adapter = new VpZhiHuAdapter(getChildFragmentManager(), fragments, titles, getContext());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.dailyNew);
        titles.add(R.string.theme);
        titles.add(R.string.column);
        titles.add(R.string.hot);

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DailyFragment());
        fragments.add(new ThemeFragment());
        fragments.add(new ColumnFragment());
        fragments.add(new HotFragment());
    }


}
