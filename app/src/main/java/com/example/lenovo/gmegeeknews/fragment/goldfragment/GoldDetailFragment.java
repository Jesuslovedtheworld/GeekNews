package com.example.lenovo.gmegeeknews.fragment.goldfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.goldadapter.RlvGoldDelaAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.Constants;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.EmptyPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.mainview.EmptyView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/*
 * *  author gme
 *    time 2019年4月18日19:10:37
 */

public class GoldDetailFragment extends BaseFragment<EmptyView, EmptyPersenter> implements EmptyView{


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private int num = 10;
    private int page = 1;
    private ArrayList<GoldDetaBean.ResultsBean> arr;
    private RlvGoldDelaAdapter adapter;

    public static GoldDetailFragment newInstance(String text) {
        GoldDetailFragment fragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TITLE, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected EmptyPersenter initPersenter() {
        return new EmptyPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gold__design_layout;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        String title = bundle.getString(Constants.TITLE);
        if (title != null) {
            tv.setText(title);
            LogUtils.logD(GoldDetailFragment.class, "信息" + title);
            if (title.equals("ANDROID")){
                mPersenter.getGoldDetaData("Android",num,page);
            }
        }
    }

    @Override
    protected void initData() {
            re.setLayoutManager(new LinearLayoutManager(getContext()));
        arr = new ArrayList<>();
        adapter = new RlvGoldDelaAdapter(arr, getContext());
        re.setAdapter(adapter);
    }

    @Override
    public void onSuccess(GoldDetaBean bean) {
                if (bean != null){
                    arr.addAll(bean.getResults());
                    adapter.setArr(arr);
                    adapter.notifyDataSetChanged();
                }
    }

    @Override
    public void onFile(String s) {
        ToastUtil.showShort(s);
    }
}
