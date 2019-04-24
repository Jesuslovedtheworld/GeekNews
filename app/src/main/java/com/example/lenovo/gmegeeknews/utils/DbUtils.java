package com.example.lenovo.gmegeeknews.utils;

import com.example.lenovo.gmegeeknews.base.BaseApp;
import com.example.lenovo.gmegeeknews.bean.daobean.GeekCollectionDaoBean;
import com.example.lenovo.gmegeeknews.dao.DaoMaster;
import com.example.lenovo.gmegeeknews.dao.DaoSession;
import com.example.lenovo.gmegeeknews.dao.GeekCollectionDaoBeanDao;

import java.util.List;

/*
 * *  author gme
 *    time 2019年4月19日 09:46:45
 */
public class DbUtils extends BaseApp {
    private static volatile BaseApp app;
    private final GeekCollectionDaoBeanDao collectionDao;

    private DbUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(BaseApp.getInstance(), "GeekCollection.db");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        collectionDao = session.getGeekCollectionDaoBeanDao();
    }

    public static BaseApp getApp() {//单利模式
        if (app == null) {
            synchronized (BaseApp.class) {
                if (app == null) {
                    app = new BaseApp();
                }
            }
        }
        return app;
    }

    public List<GeekCollectionDaoBean> query() {
        return collectionDao.queryBuilder().list();
    }

    public void delete(GeekCollectionDaoBean geekCollectionDaoBean) {
        if (has(geekCollectionDaoBean)) {
            collectionDao.delete(geekCollectionDaoBean);
        }
    }

    public void insert(GeekCollectionDaoBean geekCollectionDaoBean) {
        if (!has(geekCollectionDaoBean)) {
            collectionDao.insertOrReplace(geekCollectionDaoBean);
        }
    }

    public boolean has(GeekCollectionDaoBean geekCollectionDaoBean) {
        List<GeekCollectionDaoBean> list = collectionDao.queryBuilder().where(GeekCollectionDaoBeanDao.Properties.Title.eq(geekCollectionDaoBean.getTitle())).list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
