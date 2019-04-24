package com.example.lenovo.gmegeeknews.fragment.mainfragment;

import android.view.View;
import android.widget.TextView;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseFragment;
import com.example.lenovo.gmegeeknews.base.BasePersenter;
import com.example.lenovo.gmegeeknews.base.FlowLayout;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.AboutPersenter;
import com.example.lenovo.gmegeeknews.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class AboutFragment extends BaseFragment {

    @BindView(R.id.fl)
    FlowLayout fl;
    private ArrayList<String> mData = new ArrayList<>();

    @Override
    protected BasePersenter initPersenter() {
        return new AboutPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.about_layout;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 30; i++) {
            mData.add("流式布局:"+i);
        }
        for (int i = 0; i < mData.size(); i++) {
            //获取视图,视图可以自定义,可以添加自己想要的效果
            TextView label = (TextView) View.inflate(getActivity(), R.layout.item_label, null);
            //获取数据
            final String data = mData.get(i);
            //绑定数据
            label.setText(data);

            label.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast(data);
                }
            });

            //加到容器中,parent是FlowLayout
            fl.addView(label);
        }
    }

    private void showToast(String data) {
        ToastUtil.showShort(data);
    }


    @Override
    protected void initData() {
        mData = new ArrayList<>();

    }
}
