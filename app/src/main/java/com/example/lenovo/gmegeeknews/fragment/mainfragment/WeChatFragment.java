package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.wechatadapter.WeChatAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.wechatbean.WeChatBean;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.WechatPersenter;
import com.example.lenovo.gmegeeknews.view.mainview.WeChatHuView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.lenovo.gmegeeknews.utils.CircularAnimUtil.PERFECT_MILLS;

public class WeChatFragment extends BaseFragment<WeChatHuView, WechatPersenter> {

    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<WeChatBean> arr;
    private WeChatAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.wechat_layout;
    }

    @Override
    protected void initView() {
            //todo  支持Toolar
        arr = new ArrayList<>();
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeChatAdapter(arr, getContext());
        re.setAdapter(adapter);

    }

    @Override
    protected WechatPersenter initPersenter() {
        return new WechatPersenter();
    }



}
