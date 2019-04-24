package com.example.lenovo.gmegeeknews.view.zhihuview;

import com.example.lenovo.gmegeeknews.base.BaseMvpView;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;

public interface DailyNewsView extends BaseMvpView {
    void onSuccess(DailyNewsBean bean);
    void onFile(String s);
}
