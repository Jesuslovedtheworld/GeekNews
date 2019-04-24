package com.example.lenovo.gmegeeknews.fragment.gank;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.gankadapter.RlvGankDetaAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.Constants;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.model.gankmodel.GankDetaModel;
import com.example.lenovo.gmegeeknews.persenter.genkfragment.GankDetaPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.view.GankDetaView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * *  author gme
 *    time 2019年4月23日09:24:40
 */
public class GankDetaFragment extends BaseFragment<GankDetaView, GankDetaPersenter> implements GankDetaView{
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<GoldDetaBean.ResultsBean> arr;
    private RlvGankDetaAdapter adapter;
    private int page = 1;
    private int num = 10;

    @Override
    protected GankDetaPersenter initPersenter() {
        return new GankDetaPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gank_deta_layout;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        arr = new ArrayList<>();
        adapter = new RlvGankDetaAdapter(arr, getContext());
        re.setAdapter(adapter);
        Bundle bundle = getArguments();
        String title = bundle.getString(Constants.TITLE);
        if (title != null){
            if (title.equals("ANDROID") ){
                mPersenter.getData("Android",num,page);
            }
            if (title.equals("ISO") ){
                mPersenter.getData("iSO",num,page);
            }
            mPersenter.getData(title,num,page);
        }

    }

    @Override
    public void onFile(String s) {
        ToastUtil.showShort(s);
    }

    @Override
    public void onSuccess(GoldDetaBean bean) {
        LogUtils.logD(GankDetaModel.class,"回来的数据"+bean.toString());
            if (bean != null){
                arr.addAll(bean.getResults());
                adapter.setArr(arr);
                adapter.notifyDataSetChanged();
            }
    }
}
