package com.example.lenovo.gmegeeknews.adapter.wechatadapter;

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
import com.example.lenovo.gmegeeknews.bean.wechatbean.WeChatBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * *  author gme
 *    time 2019年4月18日17:00:23
 */
public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.WeChatVH> {

    //todo  微信实体类
    private Context context;
    private ArrayList<WeChatBean> arr;

    public WeChatAdapter(ArrayList<WeChatBean> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public WeChatVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ;
        return new WeChatVH(LayoutInflater.from(context).inflate(R.layout.wechat_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull WeChatVH weChatVH, int i) {
        WeChatBean bean = arr.get(i);
        //todo  路径修改
        Glide.with(context).load(bean).into(weChatVH.wechatImg);
        weChatVH.wechatTv.setText(bean.toString());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class WeChatVH extends RecyclerView.ViewHolder {

        @BindView(R.id.wechat_img)
        ImageView wechatImg;
        @BindView(R.id.wechat_tv)
        TextView wechatTv;
        public WeChatVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
