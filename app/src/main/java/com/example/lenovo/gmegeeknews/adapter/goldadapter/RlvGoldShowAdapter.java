package com.example.lenovo.gmegeeknews.adapter.goldadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.bean.gold.GoldShowBean;
import com.example.lenovo.gmegeeknews.widget.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
* *  author gme
*    time    时间接口
*/
public class RlvGoldShowAdapter extends RecyclerView.Adapter<RlvGoldShowAdapter.ViewH> implements TouchCallBack {

    private ArrayList<GoldShowBean> arr;
    private Context context;

    public RlvGoldShowAdapter(ArrayList<GoldShowBean> arrayList, Context context) {
        this.arr = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.gold_show_item, null);
        return new ViewH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH vh, int i) {
        final GoldShowBean bean = arr.get(i);
        vh.txt.setText(bean.getTitles());
        vh.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bean.setChecked(isChecked);
            }
        });
        vh.sc.setChecked(bean.isChecked());

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    @Override
    public void onItemExChange(int fromPosition, int toPosition) {
        Collections.swap(arr,fromPosition,toPosition);
        //局部刷新  索引混乱
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        arr.remove(position);
        //局部刷新  索引混乱 越界
        notifyItemRemoved(position);
    }


    public class ViewH extends RecyclerView.ViewHolder {
        @BindView(R.id.txt)
        TextView txt;
        @BindView(R.id.sc)
        SwitchCompat sc;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
