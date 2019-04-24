package com.example.lenovo.gmegeeknews.fragment.zhihufragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseActivity;
import com.example.lenovo.gmegeeknews.persenter.zhihupersenter.CalendarPersenter;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.zhihuview.CalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarActivity extends BaseActivity<CalendarView,CalendarPersenter> implements CalendarView, OnDateSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.view_calender)
    MaterialCalendarView viewCalender;
    @BindView(R.id.tv_calender_enter)
    TextView tvCalenderEnter;
    private CalendarDay curreatData;

    @Override
    protected CalendarPersenter initPresenter() {
        return new CalendarPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
    }


    @Override
    protected void initListener() {
       //编辑日历属性
        viewCalender.state()
                .edit()
                .setFirstDayOfWeek(Calendar.MONDAY)   //设置每周开始的第一天
                .setMinimumDate(CalendarDay.from(2010, 4, 3))  //设置可以显示的最早时间
                .setMaximumDate(CalendarDay.from(2018, 5, 12))//设置可以显示的最晚时间
                .setCalendarDisplayMode(CalendarMode.MONTHS)//设置显示模式，可以显示月的模式，也可以显示周的模式
                .commit();// 返回对象并保存
        viewCalender.setOnDateChangedListener(this);
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        curreatData = date;
    }

    private void getcurrentData() {
        int year = curreatData.getYear();
        int month = curreatData.getMonth();
        int day = curreatData.getDay();
        Date date = curreatData.getDate();
        ToastUtil.showShort("点击的年份"+year+"月份"+month+"天"+date+"日期"+date);
    }

}
