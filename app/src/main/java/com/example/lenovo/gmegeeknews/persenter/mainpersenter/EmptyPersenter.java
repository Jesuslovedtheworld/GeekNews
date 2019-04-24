package com.example.lenovo.gmegeeknews.persenter.mainpersenter;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.model.mainmodel.EmptyModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.view.mainview.EmptyView;

public class EmptyPersenter extends BasePersenter<EmptyView> implements ResultCallBack<GoldDetaBean> {
    private EmptyModel model = new EmptyModel();

    @Override
    protected void initModel() {
        models.add(model);
    }
    public void getGoldDetaData(String tech,int num,int page){
           // model.getData(tech,num,page,this);
    }

    @Override
    public void onSuccess(GoldDetaBean bean) {
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
