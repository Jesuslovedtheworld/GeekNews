package com.example.lenovo.gmegeeknews.base;

import java.util.ArrayList;

public abstract class BasePersenter <V extends BaseMvpView>{
    protected V mView;
    protected ArrayList<BaseModel> models = new ArrayList<>();
    public void bind(V view){
            this.mView = view;
    }
    protected abstract void initModel();
    public void onDestory(){
        mView = null;
        if (models.size() >  0){
            for (BaseModel model : models) {
                model.onDestory();
            }
        }
    }
}
