package com.example.lenovo.gmegeeknews.adapter.zhihuadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseApp;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.utils.SystemUtil;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.zhihuview.ZhiHuColumnView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvZhiHuColumnAdapter extends RecyclerView.Adapter<RlvZhiHuColumnAdapter.ViewHolder>  {

    private ArrayList<ZhiHuColumnBean.DataBean> arr;
    private Context context;

    public RlvZhiHuColumnAdapter(Context context, ArrayList<ZhiHuColumnBean.DataBean> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhihu_column_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhiHuColumnBean.DataBean bean = arr.get(i);
        String image = bean.getThumbnail();
        //在设置图片之前吧ImageView宽高重新设置一下
       /* if (viewHolder.column_img != null){
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.column_img.getLayoutParams();
            int imageWidth = BaseApp.widthPixels / 2 - SystemUtil.dp2px(8);
            layoutParams.weight = imageWidth;
            if (bean.getScale() != 0){
                layoutParams.height  = (int) (imageWidth / bean.getScale());
            }
            layoutParams.leftMargin = layoutParams.topMargin = SystemUtil.dp2px(4);
           ;*/
            if (image != null){
                LogUtils.logD(RlvZhiHuColumnAdapter.class,"回来的数据"+image);
                Glide.with(context).load(image).into(viewHolder.column_img);
            //}
        }


    }

    public void setArr(ArrayList<ZhiHuColumnBean.DataBean> arr) {
        this.arr = arr;
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.column_img)
        ImageView column_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
