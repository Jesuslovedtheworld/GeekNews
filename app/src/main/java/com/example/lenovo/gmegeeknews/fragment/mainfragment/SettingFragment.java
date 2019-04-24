package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.content.res.Configuration;
import android.net.wifi.hotspot2.ConfigParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.activity.MainActivity;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.SettingPersenter;
import com.example.lenovo.gmegeeknews.utils.SpUtil;
import com.example.lenovo.gmegeeknews.utils.UIModeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SettingFragment extends BaseFragment {

    @BindView(R.id.cache_box)
    CheckBox cacheBox;
    @BindView(R.id.noimg_box)
    CheckBox noimgBox;
    @BindView(R.id.night_box)
    CheckBox nightBox;

    @Override
    protected BasePersenter initPersenter() {
        return new SettingPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.settings_layout;
    }

    @Override
    protected void initView() {
        int currentNightMode = getActivity().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO){
            //判断当前是否是日渐模式
            nightBox.setChecked(false);
        }else {
            nightBox.setChecked(true);
        }
    }

    @Override
    protected void initListener() {
       /* //切换模式
        //切换日夜间模式的时候Activity会重新创建
        //对应的这个碎片也会重建,重建的时候SwitchCompat会设置默认值
        //设置默认值的时候这个回调会被调用
        //if (用户点击的情况下){
        if (buttonView.isPressed()){
            //切换并保存模式
            UIModeUtil.changeModeUI((MainActivity) getActivity());
            //保存当前碎片的type
            SpUtil.setParam(Constants.DAY_NIGHT_FRAGMENT_POS,MainActivity.TYPE_SETTINGS);
        }*/
        //切换模式夜间模式的时候Activity回重新构建
        //对应的碎片也会重建，重建的时候设置false
        //设置及
        //切换日
        nightBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightBox.isChecked()){
                    UIModeUtil.changeModeUI((MainActivity)getActivity());
                    //保存当前碎片的type
                }
            }
        });

    }
}
