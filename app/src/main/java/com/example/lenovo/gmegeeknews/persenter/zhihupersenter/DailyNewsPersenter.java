package com.example.lenovo.gmegeeknews.persenter.zhihupersenter;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;
import com.example.lenovo.gmegeeknews.model.zhihumodel.DailyModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.view.zhihuview.DailyNewsView;


public class DailyNewsPersenter extends BasePersenter<DailyNewsView> implements ResultCallBack<DailyNewsBean> {

    private static final String TAG = "DailyNewsPersenter";
    private DailyModel model = new DailyModel();

    @Override
    protected void initModel() {
        models.add(model);
    }

    @Override
    public void onSuccess(DailyNewsBean bean) {
                if (bean != null){
                    if (mView != null){
                        mView.onSuccess(bean);
                    }
                }
    }

    @Override
    public void onFile(String s) {
        if (mView != null){
            mView.onFile(s);
        }
    }

    public void getData() {
            model.getData(this);
    }
}
