package com.example.lenovo.gmegeeknews.model.zhihumodel;

import android.util.Log;

import com.example.lenovo.gmegeeknews.base.BaseModel;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;
import com.example.lenovo.gmegeeknews.net.MyApi;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhiHu_HotModel extends BaseModel {
    private final String TAG = "ZhiHu_HotModel";
    public void getHotData(final ResultCallBack<ZhiHuHotBean> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.zhiFuDailyNewsUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        Observable<ZhiHuHotBean> huHot = api.getZhiHuHot();
        huHot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiHuHotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiHuHotBean zhiHuHotBean) {
                        Log.d(TAG, "网络请求回来的数据 "+zhiHuHotBean);
                            if (zhiHuHotBean != null){
                                resultCallBack.onSuccess(zhiHuHotBean);
                            }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e != null){
                            resultCallBack.onFile(e.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
