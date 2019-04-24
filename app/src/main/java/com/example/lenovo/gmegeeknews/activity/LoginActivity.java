package com.example.lenovo.gmegeeknews.activity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseActivity;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.LoginPersneter;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;
import com.example.lenovo.gmegeeknews.view.mainview.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView,LoginPersneter> implements LoginView {
    //找出控件
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.name)
    EditText et_name;
     @BindView(R.id.psd)
     EditText et_psd;
    @Override
    protected LoginPersneter initPresenter() {//p层
        return new LoginPersneter();
    }

    @Override
    protected int getLayoutId() {//返回布局
        return R.layout.activity_login;
    }

    @Override
    public void setData(String s) {

    }

    @Override
    public String getUserName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return et_psd.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }

    @OnClick({R.id.btn})
    public void click(View v){
        mPersenter.login();
    }

}
