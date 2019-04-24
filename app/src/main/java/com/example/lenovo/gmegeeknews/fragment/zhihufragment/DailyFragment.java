package com.example.lenovo.gmegeeknews.fragment.zhihufragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.activity.V2exNodeActivity;
import com.example.lenovo.gmegeeknews.activity.VtexWebActivity;
import com.example.lenovo.gmegeeknews.adapter.zhihuadapter.RlvZhiHuDailyNewsAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;
import com.example.lenovo.gmegeeknews.persenter.zhihupersenter.DailyNewsPersenter;
import com.example.lenovo.gmegeeknews.utils.CircularAnimUtil;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.zhihuview.DailyNewsView;
import com.example.lenovo.gmegeeknews.widget.VtexItemOnClick;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends BaseFragment<DailyNewsView, DailyNewsPersenter> implements DailyNewsView, View.OnClickListener, VtexItemOnClick {

    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.fb)
    FloatingActionButton fb;
    private ArrayList<DailyNewsBean.StoriesBean> newList;
    private ArrayList<DailyNewsBean.TopStoriesBean> bannerList;
    private RlvZhiHuDailyNewsAdapter adapter;
    private String timeData = "今日新闻";


    @Override
    protected DailyNewsPersenter initPersenter() {
        return new DailyNewsPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        newList = new ArrayList<>();
        bannerList = new ArrayList<>();
        adapter = new RlvZhiHuDailyNewsAdapter(getContext(), newList, bannerList);
        re.setAdapter(adapter);
        fb.setOnClickListener(this);
        adapter.setVtexItemOnClick(this);
    }

    @Override
    protected void initData() {
       mPersenter.getData();

    }

    @Override
    public void onSuccess(DailyNewsBean bean) {
        timeData = bean.getDate();
        bannerList.clear();
        List<DailyNewsBean.TopStoriesBean> top_stories = bean.getTop_stories();
        if (top_stories != null && top_stories.size() > 0) {
            bannerList.addAll(top_stories);
        }
        newList.clear();
        List<DailyNewsBean.StoriesBean> stories = bean.getStories();
        if (stories != null && stories.size() > 0) {
            newList.addAll(stories);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb:
                Intent it = new Intent();
                it.setClass(getContext(),CalendarActivity.class);
                CircularAnimUtil.startActivity(getActivity(),it,fb,R.color.fab_bg);
                break;
        }
    }

    //跳转页面
    @Override
    public void onItemListener(int id) {
        Intent intent = new Intent(getContext(), VtexWebActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
