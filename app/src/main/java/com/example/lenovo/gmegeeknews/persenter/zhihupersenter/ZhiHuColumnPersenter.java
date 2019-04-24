package com.example.lenovo.gmegeeknews.persenter.zhihupersenter;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;
import com.example.lenovo.gmegeeknews.model.zhihumodel.ZhiHuColumnModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.zhihuview.ZhiHuColumnView;
/*
* *  author gme
*/
public class ZhiHuColumnPersenter extends BasePersenter<ZhiHuColumnView> implements ResultCallBack<ZhiHuColumnBean> {
    private   ZhiHuColumnModel model = new ZhiHuColumnModel();;
    @Override
    protected void initModel() {
        models.add(model);
    }
    public void getData(){
        model.getColumn(this);
    }

    @Override
    public void onSuccess(ZhiHuColumnBean bean) {
            if (bean != null){
                    if (mView != null){
                        mView.onSuccess(bean);
                    }
            }
    }

    @Override
    public void onFile(String s) {
        if (s != null){
            if (mView != null){
                mView.onFile(s);
            }
        }

    }
}
