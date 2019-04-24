package com.example.lenovo.gmegeeknews.view.mainview;
//高蒙恩
import com.example.lenovo.gmegeeknews.base.BaseMvpView;
//MainView对应的V层
public interface LoginView extends BaseMvpView {
        void setData(String s);
        String getUserName();
        String getPsw();
        void showToast(String msg);
}


