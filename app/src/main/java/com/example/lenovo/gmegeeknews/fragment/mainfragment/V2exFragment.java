package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.activity.V2exNodeActivity;
import com.example.lenovo.gmegeeknews.adapter.v2exadapter.RlvV2exHtmlAdapter;
import com.example.lenovo.gmegeeknews.adapter.v2exadapter.VpV2exHtmlAdapter;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.bean.v2ex.V2exTabBean;
import com.example.lenovo.gmegeeknews.fragment.v2xefragment.V2exHtmlFragment;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.V2exPersenter;
import com.example.lenovo.gmegeeknews.view.mainview.V2exVView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/*
 * *  author gme
 *    time 2019年4月20日19:18:43
 */

public class V2exFragment extends BaseFragment<V2exVView, V2exPersenter> implements View.OnClickListener {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.img)
    ImageView img;
    private String mUrl = "https://www.v2ex.com/";
    private ArrayList<V2exTabBean> v2exTabBeans = new ArrayList<>();

    private VpV2exHtmlAdapter adapter;
    private RlvV2exHtmlAdapter v2exHtmlAdapter;
    private String linkHref;

    @Override
    protected V2exPersenter initPersenter() {
        return new V2exPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xtex_login;
    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //查找id是tabs的div元素，因为只有一个，直接调用了first()
                    Document document = Jsoup.connect(mUrl).get();
                    Element tas = document.select("div#Tabs").first();
                    //查找带有href属性的元素
                    Elements allTabs = tas.select("a[href]");
                    for (Element allTab : allTabs) {
                        linkHref = allTab.attr("href");
                        String text = allTab.text();
                        V2exTabBean bean = new V2exTabBean(linkHref, text);
                        v2exTabBeans.add(bean);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList<Fragment> fragments = new ArrayList<>();
                            for (V2exTabBean bean : v2exTabBeans) {
                                V2exHtmlFragment fragment = new V2exHtmlFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("gme", bean.getLine());
                                fragment.setArguments(bundle);
                                fragments.add(fragment);
                            }
                            adapter = new VpV2exHtmlAdapter(getChildFragmentManager(), fragments, v2exTabBeans);
                            vp.setAdapter(adapter);
                            tab.setupWithViewPager(vp);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    @Override
    protected void initListener() {
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            startActivity(new Intent(getContext(),V2exNodeActivity.class));
    }
}
