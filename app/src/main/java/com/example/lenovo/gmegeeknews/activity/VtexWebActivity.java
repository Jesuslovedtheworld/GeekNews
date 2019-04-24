package com.example.lenovo.gmegeeknews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.bean.v2ex.VtexWebBean;
import com.example.lenovo.gmegeeknews.net.MyApi;
import com.example.lenovo.gmegeeknews.utils.LogUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VtexWebActivity extends AppCompatActivity {

    private ImageView img;
    private int id;
    private TextView mTitle;
    private TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtex_web);
        initView();
        initData();


    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.vtexUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        Observable<VtexWebBean> observable = api.getVtexBean(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VtexWebBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VtexWebBean vtexWebBean) {
                        if (vtexWebBean != null) {
                            setView(vtexWebBean);
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

    private void setView(VtexWebBean vtexWebBean) {
        Glide.with(this).load(vtexWebBean.getImage()).into(img);
        mTitle.setText(vtexWebBean.getTitle());
        jsoupHtml(vtexWebBean);

    }

    private void jsoupHtml(VtexWebBean vtexWebBean) {
        String body = vtexWebBean.getBody();

     /*<div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/v2-3cf1773d2ac7fb3acc3ff04e76676d68_is.jpg">
     <span class="author">李昕，</span><span class="bio">新生儿科医生，一个宝宝的妈妈</span>
     </div>

     <div class="content">*/
     new Thread(new Runnable() {
         @Override
         public void run() {
             try {
                 Document document = Jsoup.connect("http://news-at.zhihu.com/api/4/news/9710504").get();
                 Elements select = document.select("div.meta");
                 String author = select.select("span.author").text();
                 LogUtils.logD(VtexWebActivity.class,"作者"+author);

                 String content = document.select("span.bio").text();
                 LogUtils.logD(VtexWebActivity.class,"内容"+content);


             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }).start();


        LogUtils.logD(VtexWebActivity.class,body);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        mTitle = (TextView) findViewById(R.id.title);
        mContent = (TextView) findViewById(R.id.content);
    }
}
