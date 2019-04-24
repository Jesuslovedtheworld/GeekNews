package com.example.lenovo.gmegeeknews.adapter.zhihuadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;
import com.example.lenovo.gmegeeknews.view.zhihuview.DailyNewsView;
import com.example.lenovo.gmegeeknews.widget.VtexItemOnClick;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
* *  author gme
* 1808c    2019年4月22日18:52:15
*/
public class RlvZhiHuDailyNewsAdapter extends RecyclerView.Adapter  {

    private Context context;
    private ArrayList<DailyNewsBean.StoriesBean> newList;
    private ArrayList<DailyNewsBean.TopStoriesBean> bannerList;
    private int TYPE_BANNER = 0;
    private int TYPE_TIME = 1;
    private int TYPE_NEWS = 2;
    private String timeData = "今日新闻";
    private VtexItemOnClick vtexItemOnClick;

    public void setVtexItemOnClick(VtexItemOnClick vtexItemOnClick) {
        this.vtexItemOnClick = vtexItemOnClick;
    }
    public RlvZhiHuDailyNewsAdapter(Context context, ArrayList<DailyNewsBean.StoriesBean> newList,
                                    ArrayList<DailyNewsBean.TopStoriesBean> bannerList) {

        this.context = context;
        this.newList = newList;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (i == TYPE_BANNER) {
            return new BannerVH(inflater.inflate(R.layout.zhihu_banner, null));
        } else if (i == TYPE_TIME) {
            return new TimeVH(inflater.inflate(R.layout.zhihu_time, null));
        } else {
            return new NewsVH(inflater.inflate(R.layout.zhihu_news, null));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type == TYPE_BANNER) {
            BannerVH bannerVH = (BannerVH) viewHolder;
            bannerVH.banner.setImages(bannerList);
            bannerVH.banner.setImageLoader(new MyImageLoader());
            bannerVH.banner.start();
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (vtexItemOnClick != null){
                            vtexItemOnClick.onItemListener(bannerList.get(i).getId());
                        }
                }
            });
        }else if (type == TYPE_TIME){
            TimeVH timeVH = (TimeVH) viewHolder;
            timeVH.time.setText(timeData);
        }else if (type == TYPE_NEWS){
            int mPostition = i -1;
            if (bannerList.size() > 0 ){
                mPostition -= 1;
            }
            final DailyNewsBean.StoriesBean bean = newList.get(mPostition);
            NewsVH newsVH = (NewsVH) viewHolder;
            Glide.with(context).load(bean.getImages().get(0)).into(newsVH.newsImg);
            newsVH.newsTv.setText(bean.getTitle());
            final int finalMPostition = mPostition;
            newsVH.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (vtexItemOnClick != null){
                        vtexItemOnClick.onItemListener(bean.getId());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {//判断  如果有banner  集合的长度加二
        if (bannerList.size() > 0) {
            return newList.size() + 1 + 1;
        }
        return newList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (bannerList.size() > 0) {
            if (position == 0) {
                return TYPE_BANNER;
            } else if (position == 1) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        } else {
            if (position == 0) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        }
    }



    class BannerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;
        public BannerVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class TimeVH extends RecyclerView.ViewHolder {
        @BindView(R.id.time)
        TextView time;
        public TimeVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class NewsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.news_img)
        ImageView newsImg;
        @BindView(R.id.news_tv)
        TextView newsTv;

        public NewsVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    class MyImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            DailyNewsBean.TopStoriesBean bean = (DailyNewsBean.TopStoriesBean) path;
            Glide.with(context).load(bean.getImage()).into(imageView);
        }
    }
}
