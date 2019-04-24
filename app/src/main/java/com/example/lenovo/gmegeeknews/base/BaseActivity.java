package com.example.lenovo.gmegeeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 *      Create by Gaomengen on 2019/4/2
 *      MVP
 *      V  处理视图   用户交互
 *      P 业务逻辑   链接V 和M 层 的桥梁
 *      M  处理数据  网络数据  io操作   。。耗时操作
 */
                //泛型 V
public abstract class BaseActivity <V extends  BaseMvpView,P extends BasePersenter> extends AppCompatActivity {
    protected P mPersenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getLayoutId());   //找布局的方法 子类重写父类的抽象方法
        ButterKnife.bind(this);
        mPersenter = initPresenter();
        if (mPersenter != null){
            //直接强转不对   因为BaseActivity不作为页面展示  展示的都是他的子类
            //而子类必须实现BaseMvpView
            mPersenter.bind((V)this);
        }
        
        initView(); //初始化方法
        initListener();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();   //方法都是受保护的

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //切断V层和P层的联系
        mPersenter.onDestory();
        mPersenter = null;
    }
}
