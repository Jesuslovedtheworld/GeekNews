package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.CollectPersenter;

public class CollectFragment extends BaseFragment {

    @Override
    protected BasePersenter initPersenter() {
        return new CollectPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.collect_layout;
    }
}
