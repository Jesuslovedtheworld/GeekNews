package com.example.lenovo.gmegeeknews.persenter.zhihupersenter;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;
import com.example.lenovo.gmegeeknews.model.zhihumodel.ZhiHu_HotModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.view.zhihuview.ZhiHuHotView;

public class ZhiHuHotPersenter extends BasePersenter<ZhiHuHotView>{

    private ZhiHu_HotModel model = new ZhiHu_HotModel();

    @Override
    protected void initModel() {
        models.add(model);
    }
    public void getData(){
            model.getHotData(new ResultCallBack<ZhiHuHotBean>() {
                @Override
                public void onSuccess(ZhiHuHotBean bean) {
                    if (bean != null){
                        if (mView!= null){
                            mView.onSucces(bean);
                        }
                    }
                }

                @Override
                public void onFile(String s) {
                    if (mView != null){
                        mView.onFile(s);
                    }
                }
            });
    }

}
