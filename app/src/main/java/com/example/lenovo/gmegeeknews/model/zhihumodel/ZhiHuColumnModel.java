package com.example.lenovo.gmegeeknews.model.zhihumodel;

import com.example.lenovo.gmegeeknews.base.BaseModel;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;
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

public class ZhiHuColumnModel extends BaseModel {
    public void getColumn(final ResultCallBack<ZhiHuColumnBean> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.zhiFuDailyNewsUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        Observable<ZhiHuColumnBean> zhiHuColumn = api.getZhiHuColumn();
        zhiHuColumn.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiHuColumnBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiHuColumnBean zhiHuColumnBean) {
                        LogUtils.logD(ZhiHuColumnModel.class,"回来的数据"+zhiHuColumnBean);
                        if (zhiHuColumnBean != null){
                            resultCallBack.onSuccess(zhiHuColumnBean);
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
