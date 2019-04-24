package com.example.lenovo.gmegeeknews.model.mainmodel;

import com.example.lenovo.gmegeeknews.base.BaseModel;
import com.example.lenovo.gmegeeknews.bean.zhihubean.LoginBean;
import com.example.lenovo.gmegeeknews.net.MyApi;
import com.example.lenovo.gmegeeknews.net.BaseObserver;
import com.example.lenovo.gmegeeknews.net.HttpUtils;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class LoginModel extends BaseModel {
    public void logins(String name, String pwd, final ResultCallBack resultCallBack) {
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);
        Observable<LoginBean> login = myApi.login(name, pwd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //切断观察者和被观察者的连接  找到合适的时机  界面退出的时候
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        resultCallBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack.onFile(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
        MyApi myApi = HttpUtils.getInstance().getApiserver(MyApi.sBaseUrl, MyApi.class);
        Observable<LoginBean> login = myApi.login(name, pwd);
        login.compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())//切换线程
         .subscribe(new BaseObserver<LoginBean>() {
             @Override
             public void onSubscribe(Disposable d) {
                    resultCallBack.onSuccess(d);
             }

             @Override
             public void onNext(LoginBean bean) {

             }
         });
    }
}
