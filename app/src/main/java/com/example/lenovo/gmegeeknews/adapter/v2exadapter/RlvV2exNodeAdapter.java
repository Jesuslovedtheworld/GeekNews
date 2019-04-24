package com.example.lenovo.gmegeeknews.adapter.v2exadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.FlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvV2exNodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> titles;
    private ArrayList<String> contents;
    private Context context;

    public RlvV2exNodeAdapter(ArrayList<String> titles, ArrayList<String> contents, Context context) {
        this.titles = titles;
        this.contents = contents;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.v2ex_node_flow, null);
        return new FlowVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int type = viewHolder.getItemViewType();
        if (type == 1) {
            FlowVH flowVH = (FlowVH) viewHolder;

        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    class FlowVH extends RecyclerView.ViewHolder {
        @BindView(R.id.flow)
        FlowLayout flow;

        public FlowVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
