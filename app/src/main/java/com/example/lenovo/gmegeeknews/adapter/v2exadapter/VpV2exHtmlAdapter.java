package com.example.lenovo.gmegeeknews.adapter.v2exadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.gmegeeknews.bean.v2ex.V2exTabBean;

import java.util.ArrayList;

public class VpV2exHtmlAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<V2exTabBean> arr;

    public VpV2exHtmlAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<V2exTabBean> arr) {
        super(fm);
        this.fragments = fragments;
        this.arr = arr;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arr.get(position).getTab();
    }
}
