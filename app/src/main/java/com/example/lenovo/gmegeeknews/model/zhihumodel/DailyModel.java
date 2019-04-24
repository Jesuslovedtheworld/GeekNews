package com.example.lenovo.gmegeeknews.model.zhihumodel;

import android.util.Log;

import com.example.lenovo.gmegeeknews.base.BaseModel;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;
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

public class DailyModel extends BaseModel {
    private static final String TAG = "DailyModel";

    public void getData(final ResultCallBack<DailyNewsBean> resultCallBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.zhiFuDailyNewsUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);
        Observable<DailyNewsBean> zhiHuDailyNews = myApi.getZhiHuDailyNews();
        zhiHuDailyNews.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        Log.d(TAG, "网络请求回来的数据: "+dailyNewsBean.toString());
                            if (dailyNewsBean != null){
                                resultCallBack.onSuccess(dailyNewsBean);
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
