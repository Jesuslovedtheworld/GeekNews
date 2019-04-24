package com.example.lenovo.gmegeeknews.adapter.gankadapter;

import android.content.Context;
import android.support.annotation.AnimatorRes;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.media.CamcorderProfile.get;

public class RlvGankDetaAdapter extends RecyclerView.Adapter<RlvGankDetaAdapter.ViewH> {
    public void setArr(ArrayList<GoldDetaBean.ResultsBean> arr) {
        this.arr = arr;
    }

    private ArrayList<GoldDetaBean.ResultsBean> arr;
    private Context context;

    public RlvGankDetaAdapter(ArrayList<GoldDetaBean.ResultsBean> arrayList, Context context) {
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
    public void onBindViewHolder(@NonNull ViewH viewH, int i) {
        GoldDetaBean.ResultsBean bean = arr.get(i);
        List<String> images = bean.getImages();
        if (images!= null && images.size() > 0){
            String image = images.get(0);
            if (image != null){
                Glide.with(context).load(image).into(viewH.img);
            }
        }

        viewH.author.setText(bean.getWho());
        viewH.time.setText(bean.getCreatedAt());
        viewH.content.setText(bean.getDesc());
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
