package com.example.lenovo.gmegeeknews.model.gankmodel;

import com.example.lenovo.gmegeeknews.base.BaseModel;
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.net.MyApi;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GankDetaModel extends BaseModel {
    public void getData(String tech, int num, int page, final ResultCallBack<GoldDetaBean> resultCallBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.gankUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        Observable<GoldDetaBean> data = api.getGoldDetaData(tech, num, page);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoldDetaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GoldDetaBean goldDetaBean) {
                        if (goldDetaBean != null){
                            LogUtils.logD(GankDetaModel.class,"回来的数据"+goldDetaBean.toString());
                            resultCallBack.onSuccess(goldDetaBean);
                        }else {
                            resultCallBack.onFile("错误");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack.onFile(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
