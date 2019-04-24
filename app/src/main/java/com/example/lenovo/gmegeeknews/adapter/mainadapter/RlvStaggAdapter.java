package com.example.lenovo.gmegeeknews.adapter.mainadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseApp;
import com.example.lenovo.gmegeeknews.bean.FuLiBean;
import com.example.lenovo.gmegeeknews.utils.SystemUtil;
import java.nio.file.Path;
import java.util.ArrayList;

public class RlvStaggAdapter extends RecyclerView.Adapter<RlvStaggAdapter.VH> {
    private Context context;
    private ArrayList<FuLiBean.ResultsBean> arrayList;

    public RlvStaggAdapter(Context context, ArrayList<FuLiBean.ResultsBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_img, null);
        VH vh = new VH(view);
        return vh;
    }

    public void setArrayList(ArrayList<FuLiBean.ResultsBean> arrayList) {
       arrayList.addAll(arrayList);
       setImageScale();
    }

    private void setImageScale() {
        for (final FuLiBean.ResultsBean bean : arrayList) {
            if (bean.getScale() == 0){
                //未计算过宽高比
                Glide.with(context).load(bean.getUrl()).into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        float scale = resource.getIntrinsicWidth() * 1.0f / resource.getIntrinsicHeight();
                        bean.setScale(scale);
                    }
                });
            }else {
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        FuLiBean.ResultsBean bean = arrayList.get(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) vh.iv.getLayoutParams();
        int imageWidth = BaseApp.widthPixels / 2 - SystemUtil.dp2px(8);
        layoutParams.weight = imageWidth;
        if (bean.getScale() != 0){
            layoutParams.height = (int)(imageWidth/bean.getScale());
        }
        layoutParams.leftMargin = layoutParams.topMargin = SystemUtil.dp2px(4);
        vh.iv.setLayoutParams(layoutParams);

        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(SystemUtil.dp2px(6)));
        Glide.with(context).load(bean.getUrl()).apply(options).into(vh.iv);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private  ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}
