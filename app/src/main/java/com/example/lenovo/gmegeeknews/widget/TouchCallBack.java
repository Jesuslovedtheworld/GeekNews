package com.example.lenovo.gmegeeknews.widget;
/*
* *  author gme
*    time 2019年4月19日13:58:15
*/
public interface TouchCallBack {
    //条目交换
    void onItemExChange(int fromPosition,int toPosition);

    //删除条目
    void onItemDelete(int position);
}
