package com.example.lenovo.gmegeeknews.adapter.v2exadapter;

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
import com.example.lenovo.gmegeeknews.bean.v2ex.V2exContentBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvV2exHtmlAdapter extends RecyclerView.Adapter<RlvV2exHtmlAdapter.VH> {

    private Context context;
    private ArrayList<V2exContentBean> arr;

    public RlvV2exHtmlAdapter(Context context, ArrayList<V2exContentBean> arr) {
        this.context = context;
        this.arr = arr;
    }

    public void setArr(ArrayList<V2exContentBean> arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.vex_html_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        V2exContentBean bean = arr.get(i);
        Glide.with(context).load(bean.getImage()).into(vh.img);
        vh.countLivid.setText(bean.getCount_livid());
        vh.maxText.setText(bean.getMax_text());
        vh.member.setText(bean.getMember());
        vh.node.setText(bean.getNode());
        vh.timeReply.setText(bean.getTime_reply());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.member)
        TextView member;
        @BindView(R.id.time_reply)
        TextView timeReply;
        @BindView(R.id.node)
        TextView node;
        @BindView(R.id.count_livid)
        TextView countLivid;
        @BindView(R.id.max_text)
        TextView maxText;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
