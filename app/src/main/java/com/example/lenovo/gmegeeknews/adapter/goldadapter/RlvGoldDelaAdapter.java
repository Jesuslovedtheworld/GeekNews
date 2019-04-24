package com.example.lenovo.gmegeeknews.adapter.goldadapter;

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
import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.widget.TouchCallBack;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * *  author gme
 *    time    时间接口
 */
public class RlvGoldDelaAdapter extends RecyclerView.Adapter<RlvGoldDelaAdapter.ViewH>{
    public void setArr(ArrayList<GoldDetaBean.ResultsBean> arr) {
        this.arr = arr;
    }

    private ArrayList<GoldDetaBean.ResultsBean> arr;
    private Context context;

    public RlvGoldDelaAdapter(ArrayList<GoldDetaBean.ResultsBean> arrayList, Context context) {
        this.arr = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.gold_deta_item, null);
        return new ViewH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH vh, int i) {
        GoldDetaBean.ResultsBean bean = arr.get(i);
        String image = bean.getImages().get(0);
        if (image != null){
            Glide.with(context).load(image).into(vh.img);
        }
        vh.content.setText(bean.getDesc());
        vh.author.setText(bean.getWho());
        vh.time.setText(bean.getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }


    public class ViewH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.small_img)
        ImageView smallImg;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.clock)
        ImageView clock;
        @BindView(R.id.time)
        TextView time;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
