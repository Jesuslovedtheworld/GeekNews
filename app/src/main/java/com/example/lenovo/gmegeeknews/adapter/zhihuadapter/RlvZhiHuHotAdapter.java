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
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvZhiHuHotAdapter extends RecyclerView.Adapter<RlvZhiHuHotAdapter.ViewHolder>  {

    private ArrayList<ZhiHuHotBean.RecentBean> arr;
    private Context context;

    public RlvZhiHuHotAdapter(Context context, ArrayList<ZhiHuHotBean.RecentBean> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhihu_hot_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhiHuHotBean.RecentBean bean = arr.get(i);
        Glide.with(context).load(bean.getUrl()).into(viewHolder.hotImg);
        viewHolder.hotTv.setText(bean.getTitle());
    }

    public void setArr(ArrayList<ZhiHuHotBean.RecentBean> arr) {
        this.arr = arr;
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_img)
        ImageView hotImg;
        @BindView(R.id.hot_tv)
        TextView hotTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
