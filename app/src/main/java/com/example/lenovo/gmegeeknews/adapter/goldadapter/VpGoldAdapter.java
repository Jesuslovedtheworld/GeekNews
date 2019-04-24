package com.example.lenovo.gmegeeknews.adapter.goldadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.gmegeeknews.bean.gold.GoldShowBean;

import java.util.ArrayList;

public class VpGoldAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    //private ArrayList<GoldShowBean> titleArr;
    private ArrayList<String> newsTitleList = new ArrayList<>();
    public VpGoldAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<GoldShowBean> titleArr) {
        super(fm);
        this.fragments = fragments;
        //this.titleArr = titleArr;
        for (int i = 0; i < titleArr.size(); i++) {
            GoldShowBean bean = titleArr.get(i);
            if (bean.isChecked()){
                newsTitleList.add(bean.getTitles());
            }
        }
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
        return newsTitleList.get(position);
    }
}
