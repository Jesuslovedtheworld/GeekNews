package com.example.lenovo.gmegeeknews.view.zhihuview;

import com.example.lenovo.gmegeeknews.base.BaseMvpView;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;

public interface ZhiHuHotView extends BaseMvpView {
    void onSucces(ZhiHuHotBean bean);
    void onFile(String s);
}
