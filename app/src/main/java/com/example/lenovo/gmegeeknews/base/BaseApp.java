package com.example.lenovo.gmegeeknews.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;
    private int mWidthPixels;
    private int mHeightPixels;
    public static int widthPixels;
    public static int heightPixels;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        etScreenWH();
        setDayNightMode();
    }

    private void etScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();//获取屏幕默认显示
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        widthPixels = metrics.widthPixels;
        heightPixels = metrics.heightPixels;
    }

    private void setDayNightMode() {
        //根据sp里面的设置对应的夜间模式
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

}
