package com.example.lenovo.gmegeeknews.fragment.zhihufragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.zhihuadapter.RlvZhiHuColumnAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;
import com.example.lenovo.gmegeeknews.persenter.zhihupersenter.ZhiHuColumnPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.zhihuview.ZhiHuColumnView;

import java.util.ArrayList;

import butterknife.BindView;

/*
* *  author gme
*    time   2019年4月18日14:49:05
*/
public class ColumnFragment extends BaseFragment<ZhiHuColumnView, ZhiHuColumnPersenter> implements ZhiHuColumnView{


    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<ZhiHuColumnBean.DataBean> arr;
    private RlvZhiHuColumnAdapter adapter;
    private StaggeredGridLayoutManager manager;

    @Override
    protected ZhiHuColumnPersenter initPersenter() {
        return new ZhiHuColumnPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_column;
    }

    @Override
    protected void initView() {
         manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
         manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        re.setLayoutManager(manager);
        arr = new ArrayList<>();
        adapter = new RlvZhiHuColumnAdapter(getContext(), arr);
        re.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPersenter.getData();//调用数据
    }
    @Override
    public void onSuccess(ZhiHuColumnBean bean) {//接口回调的实体类
        if (bean.getData() != null && bean.getData().size() > 0 ){
            LogUtils.logD(ColumnFragment.class,"fragment的数据"+bean.toString());
            arr.addAll(bean.getData());
            adapter.setArr(arr);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onFile(String s) {
        ToastUtil.showShort(s);
    }
}
