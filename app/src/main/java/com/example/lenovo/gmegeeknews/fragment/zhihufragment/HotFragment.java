package com.example.lenovo.gmegeeknews.fragment.zhihufragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.zhihuadapter.RlvZhiHuHotAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;
import com.example.lenovo.gmegeeknews.persenter.zhihupersenter.ZhiHuHotPersenter;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.zhihuview.ZhiHuHotView;

import java.util.ArrayList;

import butterknife.BindView;

/*
 * *  author gme
 */
public class HotFragment extends BaseFragment<ZhiHuHotView, ZhiHuHotPersenter> implements ZhiHuHotView{

    private static final String TAG = "HotFragment";
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<ZhiHuHotBean.RecentBean> arr;
    private RlvZhiHuHotAdapter adapter;

    @Override
    protected ZhiHuHotPersenter initPersenter() {
        return new ZhiHuHotPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        arr = new ArrayList<>();
        adapter = new RlvZhiHuHotAdapter(getContext(), arr);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPersenter.getData();
    }
    @Override
    public void onSucces(ZhiHuHotBean bean) {
        Log.d(TAG, "fargment回来的数据: "+bean);
        if (bean.getRecent() != null && bean.getRecent().size() > 0 ){
            arr.addAll(bean.getRecent());
            adapter.setArr(arr);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onFile(String s) {
        ToastUtil.showShort(s);
    }
}
