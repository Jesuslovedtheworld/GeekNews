package com.example.lenovo.gmegeeknews.utils;

import android.util.Log;

public class LogUtils {
    private static boolean change = true;
    public static void logD(Class cls,String nameString){
        if (change == true){
            try {
                Class<?> name = Class.forName(cls.getName());
                String tagName = name.getName();
                Log.d(tagName, nameString);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
