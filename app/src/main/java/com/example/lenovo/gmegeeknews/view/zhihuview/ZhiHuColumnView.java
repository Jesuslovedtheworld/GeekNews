package com.example.lenovo.gmegeeknews.view.zhihuview;

import com.example.lenovo.gmegeeknews.base.BaseMvpView;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;

public interface ZhiHuColumnView extends BaseMvpView {
    void onSuccess(ZhiHuColumnBean bean);
    void onFile(String s);
}
