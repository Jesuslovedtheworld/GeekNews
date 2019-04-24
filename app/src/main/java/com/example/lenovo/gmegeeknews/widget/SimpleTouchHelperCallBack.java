package com.example.lenovo.gmegeeknews.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleTouchHelperCallBack extends ItemTouchHelper.Callback {
    private TouchCallBack touchCallBack;
    private boolean mSwipeEnable = true;

    public SimpleTouchHelperCallBack(TouchCallBack touchCallBack) {
        this.touchCallBack = touchCallBack;
    }

    //返回可以滑动的方向，一般使用getMovementFlags
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许向上滑动
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;

        //drag  拖拽的方向   滑动的方向
        return makeMovementFlags(drag,swipe);
    }

    /*
    * 拖动item时 可以调用Adapter 的NotifyItemMoved 方法来交换两个ViewHolder
    * */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        touchCallBack.onItemExChange(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return true;
    }

    /*
    * 当用户左右滑动item时达到删除条件就会调用  一般为一半  条目继续删除  否则条目弹回
        * * */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        touchCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }

    //支持长按拖动 默认是true
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }
    public  void setSwipeEnable(boolean enable){
            mSwipeEnable = enable;
    }
}
