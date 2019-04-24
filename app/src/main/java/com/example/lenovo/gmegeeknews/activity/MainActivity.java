package com.example.lenovo.gmegeeknews.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.gmegeeknews.R;
import com.example.lenovo.gmegeeknews.base.BaseActivity;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.AboutFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.CollectFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.GankFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.GoldFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.SettingFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.V2exFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.WeChatFragment;
import com.example.lenovo.gmegeeknews.fragment.mainfragment.ZhiHuDailyFragment;
import com.example.lenovo.gmegeeknews.persenter.mainpersenter.MainPersenter;
import com.example.lenovo.gmegeeknews.utils.LogUtils;
import com.example.lenovo.gmegeeknews.view.mainview.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
//https://github.com/Jesuslovedtheworld/GeekNews.git
//高蒙恩  1808c
public class MainActivity extends BaseActivity<MainView, MainPersenter> implements MainView, NavigationView.OnNavigationItemSelectedListener,MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener {
    @BindView(R.id.tool)
    Toolbar toolBar;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.sch)
    MaterialSearchView sch;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_COLLECT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_SETTING = 4;
    private final int TYPE_V2EX = 5;
    private final int TYPE_WECHAT = 6;
    private final int TYPE_ABOUT = 7;
    private ArrayList<Integer> titles;
    private int hintFragmentPosition;//定义一个变量
    private MenuItem mSearchItem;

    @Override
    protected MainPersenter initPresenter() {
        return new MainPersenter();
    }

    @Override
    protected int getLayoutId() {//返回布局
        return R.layout.activity_main;
    }

    //找控件方法
    @Override
    protected void initView() {
        sch.setVoiceSearch(true);//支持
        setSupportActionBar(toolBar);
        toolBar.setTitleTextColor(getResources().getColor(R.color.g_FFFFFF));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolBar, R.string.app_name, R.string.app_name);
        dl.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.g_FFFFFF));
        //将碎片装入集合
        initFragment();
        initTitles();
        zhiHuFragment();//获取知乎碎片


    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.zhihu);
        titles.add(R.string.about);
        titles.add(R.string.collect);
        titles.add(R.string.gank);
        titles.add(R.string.gold);
        titles.add(R.string.settings);
        titles.add(R.string.v2ex);
        titles.add(R.string.wechat);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiHuDailyFragment());
        fragments.add(new CollectFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new SettingFragment());
        fragments.add(new V2exFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new AboutFragment());

    }

    private void zhiHuFragment() {
        //获取管理器
        manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.add(R.id.fl, fragments.get(TYPE_ZHIHU))
                .commit();//提交
        //将tool设置数据
        toolBar.setTitle(getResources().getString(R.string.zhihu));
    }

    //监听方法
    @Override
    protected void initListener() {
        na.setNavigationItemSelectedListener(this);//策划监听
        sch.setOnQueryTextListener(this);
        sch.setOnSearchViewListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();//获取id  判断是否成选中状态
        if (id != R.id.options && id != R.id.info) {
            menuItem.setCheckable(true);//true  为选中状态
            //判断id  改变碎片
            switch (menuItem.getItemId()) {
                case R.id.zhihu://转换碎片
                    switchFragment(TYPE_ZHIHU);
                    break;
                case R.id.about:
                    switchFragment(TYPE_ABOUT);
                    break;
                case R.id.collect:
                    switchFragment(TYPE_COLLECT);
                    break;
                case R.id.gank:
                    switchFragment(TYPE_GANK);
                    break;
                case R.id.gold:
                    switchFragment(TYPE_GOLD);
                    break;
                case R.id.settings:
                    switchFragment(TYPE_SETTING);
                    break;
                case R.id.v2ex:
                    switchFragment(TYPE_V2EX);
                    break;
                case R.id.wechat:
                    switchFragment(TYPE_WECHAT);
                    break;
            }
            dl.closeDrawer(Gravity.LEFT);//每次点击碎片后   侧滑消失
        }else {
            menuItem.setCheckable(false);

        }

        return false;
    }

    private void switchFragment(int type) {
        //获点击的碎片
        Fragment fragment = fragments.get(type);
        Fragment hintFragment = fragments.get(hintFragmentPosition);
        FragmentTransaction beginTransaction = manager.beginTransaction();

        if (!fragment.isAdded()){//判断碎片是否被添加
                beginTransaction.add(R.id.fl,fragment);//添加
        }
        beginTransaction.hide(hintFragment);//隐藏默认的碎片
        beginTransaction.show(fragment);//显示点击的碎片
        beginTransaction.commit();//提交

        hintFragmentPosition = type;//点击之后  将点击的碎片保存起来
        //显示或隐藏 搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            mSearchItem.setVisible(true);
        }else {
            mSearchItem.setVisible(false);
        }
    }
    //查询时
    @Override
    public boolean onQueryTextSubmit(String query) {
        LogUtils.logD(MainActivity.class,"query的方法走了");
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        LogUtils.logD(MainActivity.class,"onQueryTextChange的方法走了");
        return false;
    }

    //当输入框输入东西时  走这个方法
    @Override
    public void onSearchViewShown() {
        LogUtils.logD(MainActivity.class,"onSearchViewShown的方法走了");
    }

    @Override
    public void onSearchViewClosed() {
        LogUtils.logD(MainActivity.class,"onSearchViewClosed的方法走了");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_box,menu);
        mSearchItem = menu.findItem(R.id.action_search);
        //隐藏搜索框
        mSearchItem.setVisible(false);
        sch.setMenuItem(mSearchItem);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME && event.getRepeatCount() == 0 ){
            dialog_Exit();
        }
        return false;
    }

    private void dialog_Exit() {
                 new AlertDialog.Builder(this)
                .setTitle("确定退出GeekNews吗")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // finish();
                        android.os.Process.killProcess(android.os.Process
                                .myPid());
                    }
                })
                .setNegativeButton("取消", null)
                         .create()
                         .show();


    }
}
