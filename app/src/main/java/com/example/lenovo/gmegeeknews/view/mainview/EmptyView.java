package com.example.lenovo.gmegeeknews.view.mainview;

import com.example.lenovo.gmegeeknews.base.BaseMvpView;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;

public interface EmptyView extends BaseMvpView {
    void onSuccess(GoldDetaBean bean);

    void onFile(String s);
}
