package com.example.lenovo.gmegeeknews.persenter.genkfragment;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.model.gankmodel.GankDetaModel;
import com.example.lenovo.gmegeeknews.model.mainmodel.GankModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.mainview.GankView;
import com.example.lenovo.gmegeeknews.view.view.GankDetaView;

public class GankDetaPersenter extends BasePersenter<GankDetaView> implements ResultCallBack<GoldDetaBean> {
    private GankDetaModel model = new GankDetaModel();
    @Override
    protected void initModel() {
            models.add(model);
    }
    public void getData(String tech,int num,int page){
            model.getData(tech,num,page,this);
    }

    @Override
    public void onSuccess(GoldDetaBean bean) {
        LogUtils.logD(GankDetaModel.class,"回来的数据"+bean.toString());
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
}
