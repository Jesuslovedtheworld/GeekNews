package com.example.lenovo.gmegeeknews.persenter.mainpersenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.bean.zhihubean.LoginBean;
import com.example.lenovo.gmegeeknews.model.mainmodel.LoginModel;
import com.example.lenovo.gmegeeknews.net.ResultCallBack;
import com.example.lenovo.gmegeeknews.view.mainview.LoginView;

public class LoginPersneter extends BasePersenter<LoginView>  {
    private LoginModel model= new LoginModel();
    //p层  调用M层的方法



    public void getData() {
        String data = "网络回来的数据";
        if (mView != null) {
            //((LoginView)mView).setData(data);
            mView.setData(data);
        }
    }

    //通过View对象  获取相对应的用户名 密码
    public void login() {
        String name = mView.getUserName();
        String psw = mView.getPsw();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(psw)) {//判断是否为空
            mView.showToast("账号或密码不能为空");
            return;
        }
        //进行网络请求
        Log.e("tag", "账号 密码 》》》》》》》》》》》: "+ name+"pwd"+psw);
        model.logins(name, psw, new ResultCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean != null) {
                    if (bean.getCode() == 200) {
                        //防止页面销毁  数据返回后设置页面空指针
                        if (mView != null) {
                            mView.showToast("登录成功");
                        }
                    } else {
                        if (mView != null) {
                            mView.showToast("登录失败");
                        }
                    }
                }
            }

            @Override
            public void onFile(String s) {
                if (mView != null){
                    mView.showToast("登录失败");
                }
            }
        });
    }
    @Override
    protected void initModel() {//重写 抽象方法  创建Modle层对象  并将对象添加到集合中去
        model = new LoginModel();
        models.add(model);//父类的集合
    }
}
