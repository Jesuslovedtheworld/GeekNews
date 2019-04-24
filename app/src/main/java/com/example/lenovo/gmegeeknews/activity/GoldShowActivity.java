package com.example.lenovo.gmegeeknews.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.goldadapter.RlvGoldShowAdapter;
import com.example.lenovo.gmegeeknews.base.BaseActivity;
import com.example.lenovo.gmegeeknews.base.Constants;
import com.example.lenovo.gmegeeknews.bean.gold.GoldShowBean;
import com.example.lenovo.gmegeeknews.persenter.goldpersenter.GoldShowPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.model.goldmodel.GoldShowView;
import com.example.lenovo.gmegeeknews.widget.SimpleTouchHelperCallBack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;

public class GoldShowActivity extends BaseActivity<GoldShowView,GoldShowPersenter> implements GoldShowView, View.OnClickListener {

    @BindView(R.id.tool)
    Toolbar tool;
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<GoldShowBean> arr;
    private RlvGoldShowAdapter adapter;

    @Override
    protected GoldShowPersenter initPresenter() {
        return new GoldShowPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gold_show;
    }

    @Override
    protected void initView() {
        setSupportActionBar(tool);
        tool.setNavigationIcon(R.drawable.ic_loading_rotate);
        Intent intent = getIntent();
        arr = (ArrayList<GoldShowBean>) intent.getSerializableExtra(Constants.LIST);
        LogUtils.logD(GoldShowActivity.class,"传过来的数据"+arr.toString());
        if (arr != null && arr.size() > 0 ){
            re.setLayoutManager(new LinearLayoutManager(this));
            adapter = new RlvGoldShowAdapter(arr, this);
            re.setAdapter(adapter);
        }
        //mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //
        //        //拖拽移动和侧滑删除的功能
        //        SimpleTouchHelperCallBack simpleTouchHelperCallBack =
        //                new SimpleTouchHelperCallBack(adapter);
        //        simpleTouchHelperCallBack.setSwipeEnable(false);
        //        ItemTouchHelper helper = new ItemTouchHelper(simpleTouchHelperCallBack);
        //        helper.attachToRecyclerView(mRlv);
        re.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //托转移动和侧滑删除的功能
        SimpleTouchHelperCallBack back = new SimpleTouchHelperCallBack(adapter);
        back.setSwipeEnable(false);
        ItemTouchHelper helper = new ItemTouchHelper(back);
        helper.attachToRecyclerView(re);
    }

    @Override
    protected void initListener() {
        tool.setNavigationOnClickListener(this);//tool上面的返回健
    }

    @Override
    public void onBackPressed() {//手机自带返回键
        finishShowActivity();
    }


    @Override
    public void onClick(View v) {
            finishShowActivity();
    }
    private void finishShowActivity() {
        Intent intent = new Intent();
        intent.putExtra(Constants.LIST,arr);
        setResult(RESULT_OK,intent);
        finish();
    }

}
