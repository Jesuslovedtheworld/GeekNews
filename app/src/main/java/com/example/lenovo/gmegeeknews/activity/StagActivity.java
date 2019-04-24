package com.example.lenovo.gmegeeknews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.mainadapter.RlvStaggAdapter;
import com.example.lenovo.gmegeeknews.bean.FuLiBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class StagActivity extends AppCompatActivity {

    private RecyclerView re;
    private StaggeredGridLayoutManager manager;
    private ArrayList<FuLiBean.ResultsBean> arr;
    private RlvStaggAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stag);
        initView();
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiP.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiP p = retrofit.create(ApiP.class);
        Observable<FuLiBean> data = p.gertData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuLiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                            if (fuLiBean != null){
                                    arr.addAll(fuLiBean.getResults());
                                    adapter.setArrayList(arr);

                            }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        re.setLayoutManager(manager);
        arr = new ArrayList<>();
        adapter = new RlvStaggAdapter(this, arr);
        re.setAdapter(adapter);
    }
    interface ApiP{
        String url = "http://gank.io/api/";

        @GET("data/%E7%A6%8F%E5%88%A9/20/1")
        Observable<FuLiBean> gertData();
    }
}
