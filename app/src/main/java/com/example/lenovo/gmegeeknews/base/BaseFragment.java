package com.example.lenovo.gmegeeknews.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseMvpView,P extends BasePersenter> extends Fragment implements BaseMvpView{

    private Unbinder unbinder;
    protected P mPersenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, view);
        mPersenter = initPersenter();
        if (mPersenter != null){
            mPersenter.bind((V)this);
        }
        initView();
        initListener();
        initData();
        return view;
    }

    protected void initData() {
    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract P initPersenter();

    protected abstract int getLayoutId() ;

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPersenter.onDestory();
        mPersenter = null;
    }
}
