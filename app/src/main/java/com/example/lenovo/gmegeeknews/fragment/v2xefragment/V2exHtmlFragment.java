package com.example.lenovo.gmegeeknews.fragment.v2xefragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.activity.V2exNodeActivity;
import com.example.lenovo.gmegeeknews.adapter.v2exadapter.RlvV2exHtmlAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.v2ex.V2exContentBean;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.V2exFragment;
import com.example.lenovo.gmegeeknews.persenter.v2expersenter.V2exHtmlPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.v2exview.V2exHtmlView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

public class V2exHtmlFragment extends BaseFragment<V2exHtmlView, V2exHtmlPersenter> {
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<V2exContentBean> arr = new ArrayList<>();
    private String mUrl = "https://www.v2ex.com";
    private String time1;


    @Override
    protected V2exHtmlPersenter initPersenter() {
        return new V2exHtmlPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.v2ex_html;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        mUrl += bundle.getString("gme");
       // getContent();
    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {

            private String count_livid1;
            private String count_livid;
            private String title1;
            private String src;
            private String author1;
            private String element1;

            @Override
            public void run() {
                //查找id是tabs的div元素，因为只有一个，直接调用了first()
                try {

                    Document document = Jsoup.connect(mUrl).get();
                    //新闻的字条目
                    Elements items = document.select("div.cell.item");
                    for (Element item : items) {
                        Element image = item.select("table  tbody tr td > a > img.avatar").first();
                        src = image.attr("src");
                        LogUtils.logD(V2exHtmlFragment.class,"图片链接"+ src);
                    }

                        //新闻的主题信息
                        Elements title = items.select("table tbody tr td span.item_title > a");
                        title1 = title.text();


                        //评论的信息
                        Elements toolElements = items.select("table tbody tr td span.topic_info");
                        Element node = toolElements.select("a.node").first();//获取程序员
                        count_livid = node.text();



                        Elements people = toolElements.select("strong > a");
                        if (people.size() > 0){
                            Element author = people.get(0);//作者
                            author1 = author.text();
                            Element time = people.get(1);//时间
                            time1 = time.text();
                            Element element = people.get(2);//ww2000e
                            element1 = element.text();

                        }
                        Element count_livids = items.select("table tbody tr td > a.count_livid").first();
                        count_livid1 = count_livids.text();

                        V2exContentBean bean1 = new V2exContentBean("https:"+src, author1, count_livid, time1, count_livid1, title1);
                        arr.add(bean1);




                } catch (IOException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        re.setLayoutManager(new LinearLayoutManager(getContext()));
                        RlvV2exHtmlAdapter adapter = new RlvV2exHtmlAdapter(getContext(), arr);
                        re.setAdapter(adapter);
                        adapter.setArr(arr);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();

    }

    private void my() {
        Document document = null;
        try {
            document = Jsoup.connect("").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements select = document.select("div.cell.item");
        Elements select1 = select.select("table tbody tr td span.item_title > a");
        String text = select1.text();
        LogUtils.logD(V2exNodeActivity.class,"中文text"+text);
                    /*String[] split = text.split("？");
                    for (String s : split) {
                        LogUtils.logD(DailyFragment.class,"中文text"+s);
                    }
                    String[] split1 = text.split(" ");
                    for (String s : split1) {
                        LogUtils.logD(DailyFragment.class,"英文text"+s);
                    }*/
    }

    private void getContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Document document = Jsoup.connect(mUrl).get();
                    Elements select = document.select("div.cell.item");//获取每个条目的最外框架

                    Elements selectImg = select.select("table tbody tr td > a > img.avatar");
                    String imageSrc = selectImg.attr("src");
                    LogUtils.logD(V2exHtmlFragment.class,"自己找的图片路径"+imageSrc);


                    Elements seleteTitle = select.select("table tbody tr td span.item_title > a");//a标签
                    String titleString = seleteTitle.text();
                    LogUtils.logD(V2exHtmlFragment.class,"自己找的主题文字"+titleString);


                    Elements selectInfo = select.select("table tbody tr td span.topic_info");
                    String infoString = selectInfo.select("a.node").text();
                    LogUtils.logD(V2exHtmlFragment.class,"自己找的基本信息"+infoString);

                    Elements selectStrong = select.select("table tbody tr td span.topic_info > a");
                    String strongString = selectStrong.text();
                    LogUtils.logD(V2exHtmlFragment.class,"自己找的作者"+strongString);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
