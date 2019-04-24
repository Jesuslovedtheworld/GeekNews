package com.example.lenovo.gmegeeknews.view.view;

import com.example.lenovo.gmegeeknews.base.BaseMvpView;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;

public interface GankDetaView extends BaseMvpView {
    void onFile(String s) ;

    void onSuccess(GoldDetaBean bean);
}
