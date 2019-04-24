package com.example.lenovo.gmegeeknews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.adapter.v2exadapter.RlvAdapter;
import com.example.lenovo.gmegeeknews.adapter.v2exadapter.RlvV2exNodeAdapter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class V2exNodeActivity extends AppCompatActivity {

    private RecyclerView re;
    private RlvAdapter rlvAdapter;
    private String url = "https://www.v2ex.com/";

    private ArrayList<String> titleList = new ArrayList<>();
   private ArrayList<String> contentList = new ArrayList<>();
    private RlvV2exNodeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v2ex_html);
        initView();
        initData();
        }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
        /*rlvAdapter = new RlvAdapter(mCars);
        re.addItemDecoration(new DividerItemDecoration(this,1));
        //返回头布局的内容
        final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return mCars.get(i).header;
            }
        };
        //自定义头布局,可不设置
        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int i) {
                View inflate = LayoutInflater.from(V2exNodeActivity.this).inflate(R.layout.item_header, null);
                TextView tv = inflate.findViewById(R.id.tv);
                tv.setText(mCars.get(i).header);

                return inflate;
            }
        });

        re.addItemDecoration(decoration);
        //头布局的点击事件
        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int i) {
                Toast.makeText(V2exNodeActivity.this, mCars.get(i).header, Toast.LENGTH_SHORT).show();
              *//*  startActivity(new Intent(getContext(), FlowActivity.class));
                startActivity(new Intent(getContext(), MaterialActivity.class));*//*
            }
        });
        re.setAdapter(rlvAdapter);

    }*/

    }
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                   Document document = Jsoup.connect(url).get();
                    Elements select = document.select("div.cell");

                   //解析的是标题集合
                   Elements select1 = select.select("table tbody tr td span.fade");
                    String text1 = select1.text();
                    String[] split = text1.split(" ");
                    for (String s : split) {
                        titleList.add(s);
                        LogUtils.logD(V2exNodeActivity.class,"集合的数据"+s);
                    }


                    Elements titleElements = select.select("table tbody tr td > a");
                    String title = titleElements.text();

                    titleList.add(title);
                    for (String s : titleList) {
                        LogUtils.logD(V2exNodeActivity.class,"标题"+s);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setAdapter();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void setAdapter() {
        re.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RlvV2exNodeAdapter(titleList, contentList,this);
        re.setAdapter(adapter);
    }
    private List<String> list=new ArrayList<>();

}
